package Tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteUserTest extends BaseTest {

    String endpoint = "/users/";
    String email = "ashleycin@gmail.com";

    @Test
    public void successDelete(){
        // create new user with email
        Response response = deleteRequest(endpoint + email,200);

    }
}
