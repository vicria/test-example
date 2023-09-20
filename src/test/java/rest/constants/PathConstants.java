package rest.constants;

public enum PathConstants {
    STATION_GET_API("/stations/all"), STATION_POST_API("/distance/count");

    private final String method;

    PathConstants(String method) {
        this.method = method;
    }

    public String getApiMethod() {
        return method;
    }
}
