package test.Api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class apiTesting {

    @Test
    public void get(){
        given().header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd").
        when().
                get("https://api.todoist.com/rest/v1/projects").
        then().
                statusCode(200);
    }
}
