package rest.request;

import rest.response.StationResponse;

import java.util.Objects;

public class CountRequest {
    private StationResponse from;
    private StationResponse to;

    public CountRequest(StationResponse from, StationResponse to) {
        this.from = from;
        this.to = to;
    }

    public StationResponse getFrom() {
        return from;
    }

    public StationResponse getTo() {
        return to;
    }

    public void setFrom(StationResponse from) {
        this.from = from;
    }

    public void setTo(StationResponse to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "CountRequest{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountRequest that = (CountRequest) o;
        return from.equals(that.from) && to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
