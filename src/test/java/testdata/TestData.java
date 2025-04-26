package testdata;

import models.User;
import models.enums.UserStatus;

public class TestData {
    public static final User DEFAULT_USER = User.builder()
            .id(0)
            .username("username")
            .firstName("firstName")
            .lastName("lastName")
            .email("email")
            .phone("password")
            .userStatus(UserStatus.ACTIVE.getValue())
            .build();

    public static final User INVALID_USER = User.builder().build();
}
