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

---
# DAO (Data Access OBject)
```java
public interface Dao<T> {
     
    Optional<T> get(long id);
     
    List<T> getAll();
     
    void save(T t);
     
    void update(T t, String[] params);
     
    void delete(T t);
}
```

---
# Usando otro serializador
```groovy
// https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-core-asl
    compile group: 'org.codehaus.jackson', name: 'jackson-core-asl', version: '1.8.0'
    compile group: 'org.codehaus.jackson', name: 'jackson-mapper-asl', version: '1.8.0'
```

---
# Parser personalizado
```java
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException; import java.util.Map;

public class JsonHelper {
 public static Map toMap(String json) {
   ObjectMapper mapper = new ObjectMapper();
   try {
       return mapper.readValue(json, Map.class);
   } catch (IOException e) { throw new RuntimeException(e); }
 }
 public static Map[] toMaps(String json) {
    ObjectMapper mapper = new ObjectMapper();
    try {
        return mapper.readValue(json, Map[].class);
    } catch (IOException e) { throw new RuntimeException(e); } }
}
```

---
# Object Model
```java
import org.javalite.activejdbc.Model;

public class Tarea extends Model {

}
```

---
# DAO parcial
```java
import org.javalite.activejdbc.*;

import java.util.ArrayList;
import java.util.List;

public class TareaDAO implements Dao<Tarea>{

    public TareaDAO(){
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:db.sqlite3", "", "");
    }

    @Override
    public List<Tarea> todos() {
        return Tarea.findAll();
    }

    public void crearFromJson(String json)
    {
        Tarea tarea = new Tarea();
        tarea.fromMap(JsonHelper.toMap(json));
        tarea.saveIt();
    }
}
```

---
# Actualizar y Eliminar?

- [Documentación oficial](http://javalite.io/activejdbc)