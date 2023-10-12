package rest.response;

import java.util.Arrays;
import java.util.List;

/**
 * станция.
 */
public class CountResponse {

    private List<StationResponse> route;

    private Integer totalTime;
    private StationResponse lastStation;

    public CountResponse() {
    }

    public CountResponse(List<StationResponse> route, Integer totalTime, StationResponse lastStation) {
        this.route = route;
        this.totalTime = totalTime;
        this.lastStation = lastStation;
    }

    public StationResponse getLastStation() {
        return lastStation;
    }

    public void setLastStation(StationResponse lastStation) {
        this.lastStation = lastStation;
    }

    public List<StationResponse> getRoute() {
        return route;
    }

    public void setRoute(List<StationResponse> route) {
        this.route = route;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }
}
