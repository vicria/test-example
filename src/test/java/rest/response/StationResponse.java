package rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * станция.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return String.join(" ", Arrays.asList(name, line));
    }
}
