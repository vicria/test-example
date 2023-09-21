package rest.dto;

import lombok.Data;

@Data
public class LastStationDto extends StationResponse {
    private String line;
    private String name;
    private String id;
}
