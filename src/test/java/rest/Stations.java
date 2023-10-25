package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
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
        StationResponse result = given()
                .when()
                .get("/stations/9933c924-e0f5-489b-81bf-1e165aa3e94c")
                .then()
                .statusCode(200) // Проверка статуса ответа
                .extract()
                .as(StationResponse.class);
        assertThat(result.getId()).isEqualTo("9933c924-e0f5-489b-81bf-1e165aa3e94c");
        assertThat(result.getLine()).isEqualTo("H\uD83D\uDFE1");
        assertThat(result.getName()).isEqualTo("Facultad de Derecho");
    }

    @Test
    public void test3() {
        StationResponse from = new StationResponse();
        from.setId("332e6edc-f6f2-4c58-8aa9-8987b82a21ed");
        from.setLine("H\uD83D\uDFE1");
        from.setName("Facultad de Derecho");

        StationResponse to = new StationResponse();
        to.setId("c2e87058-a654-49cd-9f39-eb472990d3f0");
        to.setLine("H\uD83D\uDFE1");
        to.setName("Humberto 1");

        CountRequest countRequest = new CountRequest(from, to);
        countRequest.setFrom(from);
        countRequest.setTo(to);

        CountResponse result = given()
                .accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(countRequest)
                .when()
                .post("/distance/count")
                .then()
                .statusCode(200)
                .extract()
                .as(CountResponse.class);

        assertThat(result.getTotalTime()).isEqualTo(12);
        assertThat(result.getLastStation().getName()).isEqualTo("Juan Manuel de Rosas Villa Urquiza");
        assertThat(result.getLastStation().getLine()).isEqualTo("B\uD83D\uDD34");
        assertThat(result.getLastStation().getId()).isEqualTo("4e85fd57-131b-4970-8aaf-f93b4a5fa50b");
        assertThat(result.getRoute().size()).isEqualTo(8);

    }
    @ParameterizedTest
    @CsvSource(value = {"H\uD83D\uDFE1 | Facultad de Derecho |      H\uD83D\uDFE1 | Humberto 1           |     12",
                        "H\uD83D\uDFE1 | Humberto 1          |      H\uD83D\uDFE1 | Facultad de Derecho  |     12",
    }, delimiter = '|')
    public void test4(String lineFrom, String stationFrom, String lineTo, String stationTo, Integer time) {
        StationResponse from = new StationResponse();
        from.setLine(lineFrom);
        from.setName(stationFrom);

        StationResponse to = new StationResponse();
        to.setLine(lineTo);
        to.setName(stationTo);

        CountRequest countRequest = new CountRequest(from, to);
        countRequest.setFrom(from);
        countRequest.setTo(to);

        CountResponse result = given()
                .contentType(ContentType.JSON)
                .body(countRequest)
                .when()
                .post("/distance/count")
                .then()
                .statusCode(200)
                .extract()
                .as(CountResponse.class);

        assertThat(result.getTotalTime()).isEqualTo(time);
        assertThat(result.getRoute().size()).isEqualTo(8);
}
}
