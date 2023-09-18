package rest;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
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
}
