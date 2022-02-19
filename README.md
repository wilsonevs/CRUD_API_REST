
# PROYECTO CRUD_API_REST


Proyecto Spring Boot que expone un API REST completo e implementa un CRUD total, desde el API REST podrás Crear, Leer, Actualizar y Eliminar elementos de una entidad.


## 🚀 Acerca de mí...
Soy una persona con alta capacidad de aprendizaje. Capaz de dar soluciones a todo tipo de problemas planteados en el manejo y manipulación de la
información aplicando análisis, diseño y construcción de soluciones de
software. Además de ser proactivo y con facilidad para el rápido aprendizaje
ante los cambios constantes de la tecnología. Actualmente me encuentro en
la búsqueda de una oportunidad para sacar al máximo provecho de mis
habilidades.

Actualmente e tenido la gran oportunidad de participar en más
de 3 proyectos importantes dentro de la organización junto con un gran
equipo de desarrolladores, donde me desempeño como desarrollador
Backend manejando lenguaje como Java, Spring Boot, Thymeleaf,
Microservicios, Postman, AWS, Bitbucket, Maven, Kafka, Mqtt, Base de datos
Sql, NoSql y despliegue en tomcat.


## Autor

- [@Github/wilsonevs](https://github.com/wilsonevs)
- [@Linkedin/wilsonevs](https://www.linkedin.com/in/wilsonvalencs/)
- [@Torre/wilsonevs](https://torre.co/wilson_evs)


## CRUD
CRUD hace referencia a un acrónimo en el que se reúnen las primeras letras de las cuatro operaciones fundamentales de aplicaciones persistentes en sistemas de bases de datos:

* Create (Crear registros)
* Read (Leer registros)
* Update (Actualizar registros)
* Delete (Borrar registros)
|CRUD-Operación | SQL    | RESTful      |
| ------------- | -------| ------------ |
| leer          | SELECT | GET          |
| Crear         | INSERT | POST, PUT    |
| Actualizar    | UPDATE | PUT          |
| Borrar        | DELETE | SELECT       |


## Instalación

Dentro de la carpeta `Configuracion` se encuentra un archivo llamado `db.properties` debe 
ingresar y configurar su conexión.
```#connection
jdbc.driverClassName = com.postgresql.Driver
jdbc.username= postgres
jdbc.password= Ingresar contraseña propia
jdbc.url = jdbc:postgresql://localhost:5432/bd_crud?useSSL=false&serverTimeZone=UTC
```
Dentro del proyecto, buscar el archivo `ContextoAplicacion` que se encuentra 
en la carpeta configuración del proyecto, aqui es donde van a ingresar la ruta 
donde se va a guardar el archivo`db.properties`, ya que es recomendable que ningún 
tercero tenga acceso a el.

```
@PropertySource("file:/xampp/htdocs/Curso/wilsonevs/configuracion/db.properties")
```

## Acceder al Swagger
Es un software de código abierto que nos permitira poder diseñar, construir, 
documentar, y utilizar servicios web RESTful.

Ruta Swagger: [Swagger](http://localhost:8089/wilsonevs/api/swagger-ui.html#/)
http://localhost:8089/wilsonevs/api/swagger-ui.html#/

## API Referencía

#### Get - Busqueda completa

```http
  GET http://localhost:8089/wilsonevs/api/auto/?paginaActual=1&paginacion=10
```

| PARAMETRO         | TIPO      | VALOR     |
| :--------         | :-------  | :---------|
| `paginaActual`    | `int`     | `1`       |
| `paginacion`      | `int`     | `100`       |

#### Get - Busqueda por ID

```http
  GET http://localhost:8089/wilsonevs/api/auto/1
```

#### Post

```http
  POST http://localhost:8089/wilsonevs/api/auto/
```

```JSON
{
  "marca": "wilsonevs",
  "anos": "2021",
  "capacidad": 500,
  "precio": 6600000
}
```

#### Put

```http
  POST http://localhost:8089/wilsonevs/api/auto/
```

```JSON
{
  "id": "1",
  "marca": "wilsonevs",
  "anos": "2021",
  "capacidad": 500,
  "precio": 6600000
}
```


#### DELETE - Eliminación por ID

```http
  GET http://localhost:8089/wilsonevs/api/auto/1
