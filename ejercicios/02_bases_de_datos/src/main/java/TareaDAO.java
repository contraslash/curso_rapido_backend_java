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

    public void crear(Tarea t) {
        // t.set("nombre", t.nombre);
        // t.set("descripcion", t.descripcion);
        t.saveIt();
    }

    @Override
    public void actualizar(Tarea tarea, String[] params) {

    }

    @Override
    public void eliminar(Tarea tarea) {

    }

}