package RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetTests extends TestBase {

    @Test
    public void getAlltoDos() {
        given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200);
    }

    @Test
    public void getToDoWithId4() {
        Response resp =
                given()
                        .pathParam("id", 4)
                        .when()
                        .get(baseUrl + "/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = resp.jsonPath();
        Assert.assertEquals(jsonPath.getJsonObject("id").toString(), "4");
    }

    @Test
    public void getAllToDosWithUserId2() {
        // https://jsonplaceholder.typicode.com/todos?userId=2
        given()
                .pathParam("userId", 2)
                .when()
                .get(baseUrl + "?{userId}")
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllUserIdWithId2andStatusCompleted() {
        // https://jsonplaceholder.typicode.com/todos?userId=2&completed=true
        given()
                .pathParam("userId", 2)
                .pathParam("completed", true)
                .when()
                .get(baseUrl + "?userId={userId}&completed={completed}")
                .then()
                .statusCode(200);
    }

    @Test
    // https://jsonplaceholder.typicode.com/todos?userId=9&completed=true&title=I%20should%20do%20the%20homework%20completed
    public void getAlltoDoWithUserId9AndTitleAndCompleted() {

        String titlevar = "I%20should%20do%20the%20homework%20completed";

        Response resp =
                given()
                        .pathParam("userId", 9)
                        .pathParam("completed", true)
                        .pathParam("title", titlevar)
                .when()
                        .get(baseUrl + "?userId={userId}&completed={completed}&title={title}")
                .then()
                        .statusCode(201)
                        .extract()
                        .response();

        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getJsonObject("userId").toString(), "9");
        Assert.assertEquals(jsonPath.getJsonObject("title").toString(), titlevar);
        Assert.assertEquals(jsonPath.getJsonObject("completed").toString(), true);
    }

    @Test
    public void getCompanyUsersWithName() {
        // https://jsonplaceholder.typicode.com/users/?company.name=Deckow-Crist
        Response resp =
        given()
                .when()
                .pathParam("companyName", "Deckow-Crist")
                .get(baseUrlUsers + "/?company.name={companyName}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getJsonObject("company.name")
                .toString()
                .substring(1,13), "Deckow-Crist");

        Assert.assertEquals(jsonPath.getJsonObject("company.name")
                .toString()
                .replace("[", "")
                .replace("]", ""), "Deckow-Crist");

    }

}