# Ejemplo Rest Controller

- Revisar `applicaftion.properties` para la base de datos.

MacOs / Linux

```bash
$ ./mvnw spring-boot:run
```

Windows

```bash
$ mvnw spring-boot:run
```

## Endpoints disponibles

- GET: http://localhost:8080/hello
    - params: `name`
- GET: http://localhost:8080/api/todos . Lista con todos los TODOS disponibles
- POST: http://localhost:8080/api/todos . Crea un nuevo TODO con los parametros que se le pasan.
    - params: 
        - `description`: string
        - `completed`: bool
- POST: http://localhost:8080/api/todos/toggle/:id . Cambia el todo a `!completed`.
    - params: `id` -> /api/todos/toggle/1