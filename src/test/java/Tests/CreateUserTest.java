package Tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest {

    String endpoint = "/users";
    String email = "ashleycin@gmail.com";

    @AfterEach
    public void successDelete() {
        Response response = deleteRequest(endpoint + email, 200);

    }

    @Test
    public void successfulCreatedUser() {
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("ashleycin@gmail.com")
                .full_name("Ashley Cin")
                .password("2345678")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);


        //delete created user
    }

    @Test
    public void createUserWithEmptyPassword() {
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("ashleycin@gmail.com")
                .full_name("Ashley Cin")
                .password(" ")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 401, requestBody);
    }

    @Test
    public void createUserWithIncorrectEmail() {
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("ashleycingmail.com")
                .full_name("Ashley Cin")
                .password("2345678")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 401, requestBody);
    }

    @Test
    public void createUserWithNameOnlyNumbers() {
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("ashleycin@gmail.com")
                .full_name("234567")
                .password("2345678")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 401, requestBody);
    }

}
