package controllers;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.aeonbits.owner.ConfigFactory;
import config.TestPropertiesConfig;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class UserController {
    RequestSpecification requestSpecification;
    public static final String USER_ENDPOINT = "user";

    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class,
            System.getProperties());

    public UserController() {
        this.requestSpecification = given()
                .log().all()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(configProperties.getApiBaseUrl())
                .filter(new AllureRestAssured());
    }

    @Step
    public Response createUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .post(USER_ENDPOINT)
                .andReturn();
    }

    @Step
    public Response updateUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .put(USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }

    @Step
    public Response getUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .get(USER_ENDPOINT + "/" + username)
                .andReturn();
    }

    @Step
    public Response deleteUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .delete(USER_ENDPOINT + "/" + username)
                .andReturn();
    }
}
