package rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * маршрут.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteResponse {

    /**
     * лист станций маршнута.
     */
    private List<StationResponse> route;

    /**
     * время движения.
     */
    private Integer totalTime;

    /**
     * последняя станция. (???)
     */
    private StationResponse lastStation;
}
