#Мини REST приложение со станциями метро

запуск:
в корне (test-example) введи команду:
docker compose up

если в логе  Tomcat started on port(s): 8082 (http) with context path ''
приложение готово к работе

запросы:
GET http://localhost:8082/stations/all

пример ответа:
[
    {
        "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
        "line": "H🟡",
        "name": "Facultad de Derecho"
    },
    ...
]



POST http://localhost:8082/distance/count
BODY:
{
    "from":
    {
        "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
        "line":"H🟡",
        "name":"Facultad de Derecho"
    },
    "to":
    {
        "id": "c2e87058-a654-49cd-9f39-eb472990d3f0",
        "line":"H🟡",
        "name":"Humberto 1"
    }
}


пример ответа:

{
    "route": [
        {
            "id": "332e6edc-f6f2-4c58-8aa9-8987b82a21ed",
            "line": "H🟡",
            "name": "Facultad de Derecho"
        },
        ...
        {
            "id": "c2e87058-a654-49cd-9f39-eb472990d3f0",
            "line":"H🟡",
            "name":"Humberto 1"
        }
    ],
    "totalTime": 12
}