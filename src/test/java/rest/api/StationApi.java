package rest.api;

import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import rest.constants.PathConstants;
import rest.dto.StationRequest;
import rest.dto.StationResponse;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class StationApi {
    List<StationRequest> resultList;

    public void getStations() {
        log.info("Running getStations() method from StationApi.class ");
        resultList = given()
                .basePath(PathConstants.STATION_GET_API.getApiMethod())
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList(".", StationRequest.class);

        assertThat(resultList.size()).isEqualTo(45);
    }

    public void updateStations() {
        log.info("Update stations attributes!");

        StationRequest rq = new StationRequest();
        rq.setId("d6851bb4-7d4b-4ffb-a3a3-61f417437466");
        rq.setLine("HD83DDFE1");
        rq.setName("Facultad de Derecho");

        StationResponse rs = given()
                .basePath(PathConstants.STATION_POST_API.getApiMethod())
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then()
                .extract().as(StationResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(StationResponse::getLastStationDto)
                .isNotEqualTo(rq.getName());
    }
}