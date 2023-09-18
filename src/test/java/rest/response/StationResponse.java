package rest.response;

import java.util.Arrays;

/**
 * станция.
 */
public class StationResponse {

    /**
     * Идентификатор.
     */
    private String id;

    /**
     * Линия.
     */
    private String line;

    /**
     * Станция.
     */
    private String name;

    public StationResponse() {

    }

    public StationResponse(String id, String line, String name) {
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
        return String.join(" ", Arrays.asList(name, line));
    }
}
