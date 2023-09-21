package rest.dto;

import lombok.Data;

@Data
public class RouteItemDto extends StationResponse {
    private String line;
    private String name;
    private String id;
}