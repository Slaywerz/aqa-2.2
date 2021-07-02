package ru.netology.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanEcho {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void shouldReturnPostmanEcho() {
        given()
                //.header("Content-type", "application/json")
                //.and()
                .body("some data")
                //Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
