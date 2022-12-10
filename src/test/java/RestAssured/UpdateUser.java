package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdateUser extends TestBase {

    @Test
    public void updateOnlyName() {

        String json = "    {\n" +
                "        \"name\": \"Oskar\",\n" +
                "        \"username\": \"Testowy\",\n" +
                "        \"email\": \"testowy@test4532.pl\"\n" +
                "    }";

        Response resp =

        given()
                .pathParam("idUser", 3)
                .body(json)
                .contentType(ContentType.JSON)
        .when()
                .patch(baseUrlUsers + "/{idUser}")
        .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getJsonObject("name").toString(), "Oskar");
        Assert.assertEquals(jsonPath.getJsonObject("username").toString(), "Testowy");
        Assert.assertEquals(jsonPath.getJsonObject("website").toString(), "ramiro.info");
    }

    @Test
    public void updateUser() {

        String json = "    {\n" +
                "        \"name\": \"Oskar\",\n" +
                "        \"username\": \"Testowy\",\n" +
                "        \"email\": \"testowy@test4532.pl\"\n" +
                "    }";

        Response resp =

                given()
                        .pathParam("id", 3)
                        .body(json)
                        .contentType(ContentType.JSON)
                        .when()
                        .put(baseUrlUsers + "/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getJsonObject("name").toString(), "Oskar");
        Assert.assertEquals(jsonPath.getJsonObject("username").toString(), "Testowy");
        Assert.assertNull(jsonPath.getJsonObject("website"));

    }

}
