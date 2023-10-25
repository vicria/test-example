package rest.response;

import rest.request.CountRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CountResponse {

    private List<StationResponse> route;
    private Integer totalTime;
    private StationResponse lastStation;

    public CountResponse(){
    }

    public CountResponse(List<StationResponse> route, Integer totalTime, StationResponse lastStation) {
        this.route = route;
        this.totalTime = totalTime;
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

    public StationResponse getLastStation() {
        return lastStation;
    }

    public void setLastStation(StationResponse lastStation) {
        this.lastStation = lastStation;
    }

    @Override
    public String toString() {
        return "CountResponse{" +
                "route=" + route +
                ", totalTime=" + totalTime +
                ", lastStation=" + lastStation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountResponse)) return false;
        CountResponse that = (CountResponse) o;
        return Objects.equals(route, that.route) && Objects.equals(totalTime, that.totalTime) && Objects.equals(lastStation, that.lastStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, totalTime, lastStation);
    }
}
