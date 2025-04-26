package apiTests;

import controllers.UserController;
import io.restassured.response.Response;
import models.User;
import models.UserResponse;
import models.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PetUserTests {
    @Test
    void createUser() {
        String baseUrl = "https://petstore.swagger.io/v2/";
        String userEndpoint = "user";
        String body = """
           {
             "id": 0,
             "username": "string",
             "firstName": "string",
             "lastName": "string",
             "email": "string",
             "password": "string",
             "phone": "string",
             "userStatus": 0
           }""";

        Response response =
                given()
                    .baseUri(baseUrl)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .post(userEndpoint)
                    .andReturn();

        response.body().prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkUserResponseBody() {

        User user = new User(0, "username", "firstName", "lastName", "email", "password", "phone", 0);

        UserController controller = new UserController();

        Response response = controller.createUser(user);
        response.getBody().prettyPrint();

        User createdUser =  response.as(UserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUser.getCode());
        Assertions.assertEquals("unknown", createdUser.getType());
        Assertions.assertNotNull(createdUser.get());
        Assertions.assertTrue(Long.getLong(createdUser.getMessage()) > 17121482345);
    }

    @Test
    void createUserControllerTest() {
        User user = new User(0,
                "username",
                "firstName",
                "lastName",
                "email",
                "password",
                "phone",
                UserStatus.ACTIVE);

        UserController userController = new UserController();

        Response response = userController.createUser(user);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);


        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());
    }

}
