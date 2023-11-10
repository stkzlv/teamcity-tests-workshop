package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String name;
    private Long id;
    private String email;
    private String lastLogin;
    private String password;
    private String href;
    private Roles roles;
    private Properties properties;
}
