package models.enums;

import models.User;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
    ACTIVE(0),
    INACTIVE(1),
    SUSPENDED(2);

    private int value;
    private static Map map = new HashMap<>();

    private UserStatus(int value) {
        this.value = value;
    }

    static {
        for(UserStatus userStatus : UserStatus.values()){
            map.put(userStatus.value, userStatus);
        }
    }

    public static UserStatus valueOf(int userStatus){
        return (UserStatus) map.get(userStatus);
    }

    public int getValue() {
        return value;
    }
}
