package advanced;

import RestAssured.TestBase;
import com.github.fge.jsonschema.main.JsonSchema;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PassingJsonAnObject extends TestBase {
    @Test
    public void getPostId3() {
        Post post =
                given()
                        .when()
                        .get(" https://jsonplaceholder.typicode.com/posts/4")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response()
                        .as(Post.class);

        Assert.assertEquals(post.getId(), 4);
    }

    @Test
    public void createNewPost() {

        Post post = new Post(1, "hehehe", "123433333333");

                given()
                        .body(post)
                        .contentType(ContentType.JSON)
                        .when()
                        .post(" https://jsonplaceholder.typicode.com/posts/")
                        .then()
                        .statusCode(201)
                        .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/schemas/postSchema.json")));
    }

    @Test
    public void UpdatePost() {

Map<String, Object> post = new HashMap<>();
post.put("title", "some text");
post.put("body", "12345");

        Response resp =
                given()
                        .body(post)
                        .contentType(ContentType.JSON)
                        .when()
                        .patch("https://jsonplaceholder.typicode.com/posts/6")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }



}
