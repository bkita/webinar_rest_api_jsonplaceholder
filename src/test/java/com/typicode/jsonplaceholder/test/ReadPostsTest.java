package com.typicode.jsonplaceholder.test;

import com.typicode.jsonplaceholder.url.JSONPlaceholderUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class ReadPostsTest {

    @Test
    void shouldReturnListOf100Posts() {

        Response response = given()
                .when()
                .get(JSONPlaceholderUrl.BASE_URL + JSONPlaceholderUrl.POSTS)
                .then()
                .extract()
                .response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        JsonPath jsonBody = response.jsonPath();
        Assertions.assertThat(jsonBody.getList("id").size()).isEqualTo(100);
    }

    @Test
    void shouldReturnPostWithGivenId() {

        Response response = given()
                .pathParam("postId", 1)
                .when()
                .get(JSONPlaceholderUrl.BASE_URL + JSONPlaceholderUrl.POSTS + "/{postId}")
                .then()
                .extract()
                .response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
