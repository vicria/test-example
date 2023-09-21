package rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

@JsonAutoDetect
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationRequest implements Serializable {

    /**
     * Идентификатор.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Линия.
     */
    @JsonProperty("line")
    private String line;

    /**
     * Станция.
     */
    @JsonProperty("name")
    private String name;

    @Override
    public String toString() {
        return String.join(" ", Arrays.asList(name, line));
    }
}
