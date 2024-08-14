package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.request.CountRequest;
import rest.response.CountResponse;
import rest.response.StationResponse;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Stations {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8082"; // Укажите ваш URL
    }


    @Test
    public void test() {
        List<StationResponse> resultList = given()
                .when()
                .get("/stations/all")
                .then()
                .statusCode(200) // Проверка статуса ответа
                .extract()
                .jsonPath()
                .getList(".", StationResponse.class);

        assertThat(resultList.size()).isEqualTo(45);
    }

    @Test
    public void test2() {
        var from = new StationResponse();

        var to = new StationResponse();

        from.setId("332e6edc-f6f2-4c58-8aa9-8987b82a21ed");
        from.setLine("H🟡");
        from.setName("Facultad  de Derecho");

        to.setId("c2e87058-a654-49cd-9f39-eb472990d3f0");
        to.setLine("H🟡");
        to.setName("Humberto 1");
        CountRequest request = new CountRequest();
        request.setFrom(from);
        request.setTo(to);

        CountResponse result = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/distance/count")
                .then()
                .statusCode(200) // Проверка статуса ответа
                .extract()
                .as(CountResponse.class);

        assertThat(result.getTotalTime()).isEqualTo(12);
    }
}
