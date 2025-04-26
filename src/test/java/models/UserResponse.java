package models;

import lombok.Data;

@Data
public class UserResponse {
    private int code;
    private String type;
    private String message;
}
