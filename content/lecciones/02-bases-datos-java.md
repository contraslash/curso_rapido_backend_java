Title: Bases de datos y Java
Author: Mauricio Collazos
Date: 2019-02-05
![]()
---
class: center, middle, light, first-slide
# Bases de Datos y Java
## Mauricio Collazos
.footnote[]
---
# Tipos de bases de datos
- SQL
- No SQL
---
# SQL
Structured Query Language:

- Manejo estandarizado de algebra relacional
- Definición de estructura de datos
- Relación entre los datos
- Eficiente para millones de datos
- Normalización
---
# Bases de datos SQL
- MySQL
- PostgreSQL
- MsSQL
- MariaDB
- Oracle
- SQLite
---
class: center, middle, light
# No todo Web Service es RESTful
- Negociación de contenido
- HATEOAS (Hypermedia As The Engiene of Application State)
- Seguridad
- Versionamiento

---
class: center, middle, light
# Conceptos importantes para desarrollar APIs
- Mantener todo modular
- Facil deexplorar
- Que satisfaga los requerimientos
- Facil de extender
- Mantenga tanto privado como sea posible
- Evite cambiar endpoints y especificaciones
- Que los nombres sean explicatorios
- Documente TODO
---
# ORM
- [Open JPA](http://openjpa.apache.org/)
- [Hibernate](http://hibernate.org/)
- [Spring ORM](https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/orm.html)
- [jOOQ](https://www.jooq.org/)
- [Active JDBC](http://javalite.io/activejdbc)
---
# Acceso a data del request
```groovy
implementation 'com.google.code.gson:gson:2.8.5'
```

```java
public class Tarea{
    String nombre;
    String descripcion;
}
```

```java
post("/", (req, res) -> {
            Tarea tarea = new Gson().fromJson(req.body(), Tarea.class);
            System.out.println(tarea.nombre);
            System.out.println(tarea.descripcion);
            return "";
        });
```