package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.UsernameAndPassword;

@Data
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private UserStatus userStatus;

    public User(int i, String username, String firstName, String lastName, String email, String password, String phone, UserStatus userStatus) {
    }

    public static UsernameAndPassword builder() {
    }
}
