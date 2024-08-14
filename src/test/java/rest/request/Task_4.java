package rest.request;

import java.util.List;

/**
 * Задание4
 *
 * [
 *     {
 *       "from":
 *         {
 *             "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
 *             "line":"H🟡",
 *             "name":"Facultad de Derecho"
 *         },
 *     "chatId": "dnjk12638721j",
 *     "msgId": 9853579975,
 *     "clazzName": "RoutDto"
 *     },
 *     {
 *       "from":
 *         {
 *             "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
 *             "line":"H🟡",
 *             "name":"Facultad de Derecho"
 *         },
 *     "chatId": "dnjk12638721j",
 *     "msgId": 9853579975,
 *     "clazzName": "RoutDto"
 *     }
 * * ]
 */

public class Task_4 {
    private List<InnerClass> from;
    public static class InnerClass{
        private InnerClass2 class2;
        private String chatId;
        private Integer msgId;
        private String clazzName;
    }
    public static class InnerClass2 {
        private String id;
        private String line;
        private String name;
    }

}

