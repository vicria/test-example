package rest.request;

import java.util.List;
/**
 * Задание5
 * {
     * "from":
             * {
             * "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
             * "line":"H🟡",
             * "name":"Facultad de Derecho"
             * },
     * "chatIds": [
         * "dnjk12638721j",
         * "dnjeevsvdv721j",
         * "1223321j"
     *      ],
     * "msgId": 9853579975,
     * "clazzName": "RoutDto"
 * }
 */

public class Task_5 {
    private Start from;
    private List<String> chatIds;
    private class Start {
        private String id;
        private String line;
        private String name;
    }
    private Integer msgId;
    private String clazzName;
}
