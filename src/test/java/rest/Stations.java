package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rest.request.CountRequest;
import rest.response.CountResponse;
import rest.response.StationResponse;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Stations {

    @BeforeAll
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
        from.setId("332e6edc-f6f2-4c58-8aa9-8987b82a21ed");
        from.setLine("H🟡");
        from.setName("Facultad de Derecho");

        var to = new StationResponse();
        to.setId("c2e87058-a654-49cd-9f39-eb472990d3f0");
        to.setLine("H🟡");
        to.setName("Humberto 1");

        var request = new CountRequest();
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

    @ParameterizedTest
    @CsvSource(value = {
            "H\uD83D\uDFE1 | Facultad de Derecho |           H\uD83D\uDFE1 | Humberto 1               |            12",
            "H\uD83D\uDFE1 | Humberto 1          |           H\uD83D\uDFE1 | Facultad de Derecho      |            12",
    }, delimiter = '|')
    public void test3(String lineFrom, String stationFrom, String lineTo, String stationTo, Integer time) {
        var from = new StationResponse();
        from.setLine(lineFrom);
        from.setName(stationFrom);

        var to = new StationResponse();
        to.setLine(lineTo);
        to.setName(stationTo);

        var request = new CountRequest();
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

        assertThat(result.getTotalTime()).isEqualTo(time);
    }
}
