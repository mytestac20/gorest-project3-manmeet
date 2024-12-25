package in.co.gorest.UsersTest;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UserPostTest extends TestBase {

    static String name = "Tela Ram";
    static String email = TestUtils.getRandomValue() + "tenali.ramakrishna@15982.com";
    static String gender = "male";
    static String status = "active";

    @Test
    public void createUsers() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setGender(status);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 3b603aaa3461be76c5254dd45b9e4812bdbc0edb04871175bf44c595940f395d")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(422);
        response.then()
                .body("data", hasKey("email"))  // Checking if there's an error related to the email field
                .body("message", equalTo("Invalid request"));
    }
}
