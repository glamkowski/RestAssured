package RestAssured;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static String baseUrl = "https://jsonplaceholder.typicode.com/todos";
    public static  String baseUrlUsers = "https://jsonplaceholder.typicode.com/users";


@BeforeMethod
    public void setup() {
    RestAssured.filters(new ResponseLoggingFilter(), new RequestLoggingFilter());
}
}
