package rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequestBody {

    /**
     * станция, от которой мы прокладываем маршрут.
     */
    private StationResponse from;

    /**
     * Станция, до которой мы прокладывааем маршрут.
     */
    private StationResponse to;
}
