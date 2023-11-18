package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.response.RouteRequestBody;
import rest.response.RouteResponse;
import rest.response.StationResponse;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationsTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8082"; // Укажите ваш URL
    }


    @Test
    public void test1() {
        List<StationResponse> resultList = given()
                .when()
                .get("/stations/all")
                .then()
                .statusCode(200) // Проверка статуса ответа
                .extract()
                .jsonPath()
                .getList(".", StationResponse.class);

        assertEquals(45, resultList.size());
    }

    @Test
    public void test2() {
        RouteRequestBody requestBody = new RouteRequestBody(
                new StationResponse("332e6edc-f6f2-4c58-8aa9-8987b82a21ed", "H🟡", "Facultad de Derecho"),
                new StationResponse("c2e87058-a654-49cd-9f39-eb472990d3f0", "H🟡", "Humberto 1")
                );

        RouteResponse resultRoute = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post("/distance/count")
                .then()
                .statusCode(200)
                .extract()
                .as(RouteResponse.class);

        assertEquals(8, resultRoute.getRoute().size());
    }

}