package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import models.enums.UserStatus;

@Data
@AllArgsConstructor
@Builder
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
