package com.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;


import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
                when()
                    .get("/api/books").
                then()
                    .statusCode(200)
                    .body("size()", is(3));
    }

    @Test
    public void shouldCountAllBooks(){
        given()
                    .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when()
                    .get("/api/books/count").
                then()
                    .statusCode(200)
                    .body(is("3"));
    }

    @Test
    public void shouldGetBookById(){
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 1).when().get("/api/books/{id}").then().statusCode(200)
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Yigit"))
                .body("genre", is("IT"));
    }
}