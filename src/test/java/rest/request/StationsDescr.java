package rest.request;

public class StationsDescr {
    private String id;
    private String line;
    private String name;

    public StationsDescr() {

    }

    public StationsDescr(String id, String line, String name) {
        this.id = id;
        this.line = line;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationRequest{" +
                "id='" + id + '\'' +
                ", line='" + line + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
