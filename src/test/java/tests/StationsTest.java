package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.api.StationApi;
import rest.utils.PropertyManager;

import static rest.constants.PropertyConstants.CONFIG;
@Slf4j
@Epic("Regression")
@Feature("API")
public class StationsTest {
    private static final String URL = PropertyManager.propHandler(CONFIG, "TEST_HOST");
    private static final String id = "12345LOL";
    private static final String line = "Orange";
    private static final String name = "Paravoznaya";
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = StationsTest.URL;
    }

    @Test
    @Story("Get stations list")
    public void test1() {
        log.info("Starting test1: ");
        StationApi.getStations();
        log.info("test1 successful!");
    }

    @Test
    @Story("Change stations list")
    public void test2() {
        log.info("Starting test2: ");
        StationApi.updateStations(id,line,name);
        log.info("test2 successful!");
    }
}

