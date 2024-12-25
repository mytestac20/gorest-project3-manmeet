package in.co.gorest.UsersTest;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {

    @Test
    public void verifyUserUpdateSuccessfully() {

        String name = "Tela Ram" + "Junior";
        String email = TestUtils.getRandomValue() + "tenali.ramakrishna@15982we.com";
        String gender = "male";
        String status = "active";

        int storeId = 7598279;
        UserPojo userPojo = new UserPojo();

        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", storeId)
                .header("Authorization", "Bearer a4805c7c5cda603b60345e721f166223ec510ce5c21e457586a3e20739d66d85")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .put("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
