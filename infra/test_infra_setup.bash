cd ..

teamcity_tests_directory=$(pwd)
workdir="teamcity_tests_infrastructure"
teamcity_server_workdir="teamcity_server"
teamcity_agent_workdir="teamcity_agent"
selenoid_workdir="selenoid"
teamcity_server_container_name="teamcity-server-instance"
teamcity_agent_container_name="teamcity_agent_instance"
selenoid_container_name="selenoid_instance"
selenoid_ui_container_name="selenoid_ui_instance"

container_names=($teamcity_server_container_name $teamcity_agent_container_name $selenoid_container_name $selenoid_ui_container_name)
workdirs=($teamcity_server_workdir $teamcity_agent_workdir $selenoid_workdir)

cd infra

rm -rf $workdir
mkdir $workdir
cd $workdir

for workdir in "${workdirs[@]}"; do
  mkdir $workdir
done

for name in "${container_names[@]}"; do
  docker stop $name
  docker rm $name
done

cd $teamcity_server_workdir

docker run -d --name $teamcity_server_container_name  \
    -v $(pwd)/logs:/opt/teamcity/logs  \
    -p 8111:8111 \
    jetbrains/teamcity-server

echo "$teamcity_server_container_name is starting .."

sleep 30

cd .. && cd $selenoid_workdir
mkdir config

cp $teamcity_tests_directory/infra/browsers.json config/

docker run -d                                   \
            --name $selenoid_container_name                                 \
            -p 4444:4444                                    \
            -v /var/run/docker.sock:/var/run/docker.sock    \
            -v $(pwd)/config/:/etc/selenoid/:ro              \
    aerokube/selenoid:latest-release

image_names=($(awk -F'"' '/"image": "/{print $4}' "$(pwd)/config/browsers.json"))

echo "Pull all browsers docker images: $image_names"
for image_name in "${image_names[@]}"; do
  docker pull "$image_name"
done

docker run -d                                   \
            --name $selenoid_ui_container_name                                 \
            -p 8080:8080                                    \
            -v /var/run/docker.sock:/var/run/docker.sock    \
            -v $(pwd)/config/:/etc/selenoid/:ro              \
    aerokube/selenoid:latest-release

sleep 10

cd .. && cd .. && cd ..

echo "Start Setup Tests .."

mvn clean test -Dtest=SetupTest#startUpTest

superuser_token=$(grep -o 'Super user authentication token: [0-9]*' $teamcity_tests_directory/infra/$workdir/$teamcity_server_workdir/logs/teamcity-server.log | awk '{print $NF}')

echo "super user token: '$superuser_token'"

ip=$(ifconfig | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]*' | grep -Eo '([0-9]*\.){3}[0-9]*' | grep -v '127.0.0.1')
teamcity_server_url="http://$ip:8111"

echo "$teamcity_server_container_name is running on $teamcity_server_url"

cd infra/$teamcity_tests_infrastructure/$teamcity_agent_workdir

docker run -d --name $teamcity_agent_container_name -e SERVER_URL=$teamcity_server_url  \
    -v $(pwd)/conf:/data/teamcity_agent/conf  \
    jetbrains/teamcity-agent


##echo "Run API tests .."
##mvn test -DsuiteXmlFile=testng-suites/api-suite.xml
##
##echo "Run UI tests .."
##mvn test -DsuiteXmlFile=testng-suites/ui-suite.xml
