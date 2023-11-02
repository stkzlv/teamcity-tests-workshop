teamcity_tests_directory=$pwd
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

# Loop through the container names and stop each one

rm -rf $workdir
mkdir $workdir
cd $workdir

for workdir in "${workdirs[@]}"; do
  mkdir $workdir
done

for name in "${container_names[@]}"; do
  docker stop "$name"
  docker rm $(docker ps -a -q -f "name=$name")
done

cd $teamcity_server_workdir

docker run -it --name $teamcity_server_container_name  \
    -v $(pwd)/datadir:/data/teamcity_server/datadir \
    -v $(pwd)/logs:/opt/teamcity/logs  \
    -p 8111:8111 \
    jetbrains/teamcity-server:latest

echo "teamcity-server-instance is starting .."

sleep 30

superuser_token=$(grep -o 'Super user authentication token: [0-9]*' $(pwd)/logs/teamcity-server.log | awk '{print $NF}')

echo "super user token '$superuser_token'"

ip=$(ifconfig | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]*' | grep -Eo '([0-9]*\.){3}[0-9]*' | grep -v '127.0.0.1')
teamcity_server_url="http://$ip:8111"

echo "TeamCity Server is running on $teamcity_server_url"

cd .. && cd $teamcity_agent_workdir

docker run -it --name $teamcity_agent_container_name -e SERVER_URL=$teamcity_server_url  \
    -v $(pwd)/conf:/data/teamcity_agent/conf  \
    jetbrains/teamcity-agent


cd .. && cd $selenoid_mkdir
mkdir config

cp $teamcity_tests_directory/confgs/browsers.json config/

docker run -d                                   \
            --name $selenoid_container_name                                 \
            -p 4444:4444                                    \
            -v /var/run/docker.sock:/var/run/docker.sock    \
            -v $(pwd)/config/:/etc/selenoid/:ro              \
    aerokube/selenoid:latest-release

image_names=($(awk -F'"' '/"image": "/{print $4}' "$(pwd)/config/browsers.json"))

# Loop through the array and pull each Docker image
for image_name in "${image_names[@]}"; do
  docker pull "$image_name"
done

docker run -d                                   \
            --name $selenoid_ui_container_name                                 \
            -p 4444:4444                                    \
            -v /var/run/docker.sock:/var/run/docker.sock    \
            -v $(pwd)/config/:/etc/selenoid/:ro              \
    aerokube/selenoid:latest-release