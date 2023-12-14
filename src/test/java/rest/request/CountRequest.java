package rest.request;

import org.junit.internal.requests.SortingRequest;
import rest.response.StationResponse;

public class CountRequest {
    private StationResponse from;
    private StationResponse to;

    public CountRequest () {}
    public CountRequest(StationResponse from, StationResponse to) {
        this.from = from;
        this.to = to;
    }

    public StationResponse getFrom() {
        return from;
    }

    public void setFrom(StationResponse from) {
        this.from = from;
    }

    public StationResponse getTo() {
        return to;
    }

    public void setTo(StationResponse to) {
        this.to = to;
    }
}
