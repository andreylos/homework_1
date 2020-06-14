package test.Api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class apiHomework {
    long id;
    String name = "My test project.";
    String newName = "Updated project.";

    @Test
    public void post() {
        String bodyJson = "{\"name\": \""+name+"\"}";
        id = given().
                header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd")
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post("https://api.todoist.com/rest/v1/projects")
                .then()
                .statusCode(200)
                .extract()
                .path("id");
        System.out.println(id);
    }

    @Test(dependsOnMethods = "post")
    public void get() {
        Response response = given().
                header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd").
                when().
                get("https://api.todoist.com/rest/v1/projects");
        JsonPath path = response.jsonPath();
        List<Map> list = path.getList("");
        List<String> actualNames = new ArrayList<>();
        for (Map project: list) {
            actualNames.add((String) project.get("name"));
        }
        response.
                then().
                statusCode(200)
                .assertThat();
        assertEquals(actualNames.get(1), name);
    }

    @Test(dependsOnMethods = "get")
    public void changeName() {
        String bodyJson = "{\"name\": \""+newName+"\"}";
        given().
                header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd")
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post("https://api.todoist.com/rest/v1/projects/"+id)
                .then()
                .statusCode(204);
        Response response = given().
                header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd").
                when().
                get("https://api.todoist.com/rest/v1/projects");
        JsonPath path = response.jsonPath();
        List<Map> list = path.getList("");
        List<String> actualNames = new ArrayList<>();
        for (Map project: list) {
            actualNames.add((String) project.get("name"));
        }
        response.
                then().
                statusCode(200)
                .assertThat();
        assertEquals(actualNames.get(1), newName);
    }

    @Test(dependsOnMethods = "changeName")
    public void delete() {
        given().
                header("Authorization", "Bearer cc51e988199eeb5aaa9929b9738adcb6d7fa83fd").
                when().
                delete("https://api.todoist.com/rest/v1/projects/" + id).
                then().
                statusCode(204);
    }
}
