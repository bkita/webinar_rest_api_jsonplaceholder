package com.typicode.jsonplaceholder.test;

import com.typicode.jsonplaceholder.url.JSONPlaceholderUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateNewPostTest {

    @Test
    void shouldCreateNewPost() {

        JSONObject json = new JSONObject();
        json.put("userId", 1);
        json.put("title", "RestAssured Demo");
        json.put("body", "Test automation is fun");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .when()
                .post(JSONPlaceholderUrl.BASE_URL + JSONPlaceholderUrl.POSTS)
                .then()
                .extract()
                .response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }
}
