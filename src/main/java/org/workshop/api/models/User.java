package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private String username;
    private String name;
    private Long id;
    private String email;
    private String lastLogin;
    private String password;
    private Roles roles;
}
