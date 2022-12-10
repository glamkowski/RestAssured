package RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser extends TestBase {

    @Test
    public void DeleteUser() {

        Response resp =

                given()
                        .pathParam("id", 3)
                        .contentType(ContentType.JSON)
                        .when()
                        .delete(baseUrlUsers + "/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }
}
