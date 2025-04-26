package controllers;

import constants.CommonConstants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class UserController {
    RequestSpecification requestSpecification;

    public UserController() {
        this.requestSpecification = given()
                .log().all()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(CommonConstants.BASE_URI);
    }


    public Response createUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .post(CommonConstants.USER_ENDPOINT)
                .andReturn();
    }


    public Response updateUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .put(CommonConstants.USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }


    public Response getUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .get(CommonConstants.USER_ENDPOINT + "/" + username)
                .andReturn();
    }


    public Response deleteUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .delete(CommonConstants.USER_ENDPOINT + "/" + username)
                .andReturn();
    }
}
