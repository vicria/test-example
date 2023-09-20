package rest.api;

import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import rest.constants.PathConstants;
import rest.dto.StationResponse;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StationApi {
    static List<StationResponse> resultList;

    public static void getStations() {
        log.info("Running getStations() method from StationApi.class ");
        resultList = given()
                .basePath(PathConstants.STATION_GET_API.getApiMethod())
                .when().get()
                .then()
                .statusCode(200) // Проверка статуса ответа
                .extract()
                .jsonPath().getList(".", StationResponse.class);

        assertThat(resultList.size()).isEqualTo(45);
    }

    public static void updateStations(String id, String line, String name) {
        log.info("Update stations attributes: " + " id: " + id + ", line: " + line + ", name: " +
                name);
        given()
                .basePath(PathConstants.STATION_POST_API.getApiMethod())
                .contentType(ContentType.JSON)
                .body("{\"id\":\"" + id + "\",\"line\":\"" + line + "\",\"name\":\"" + name + "\"}")
                .when().post()
                .then()
                .statusCode(500);
    }
}