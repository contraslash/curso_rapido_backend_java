import static spark.Spark.*;

import com.google.gson.Gson;
import org.javalite.activejdbc.LazyList;
import org.json.*;
import spark.servlet.SparkApplication;


public class Application implements SparkApplication {
    @Override
    public void init() {


        get("/", (req, res) -> {

            TareaDAO tareaDAO = new TareaDAO();
             return ((LazyList<Tarea>)(tareaDAO.todos())).toJson(true);

            }
        );

        get("/params", (req, res) -> {
            return req.queryParams("param1");
        });

        post("/", (req, res) -> {

            // Tarea tarea = new Gson().fromJson(req.body(), Tarea.class);
            String tareaJson = req.body();
            TareaDAO tareaDAO = new TareaDAO();
            tareaDAO.crearFromJson(tareaJson);
            return "";
        });

        put("/json", (req, res) -> {
            JSONObject jsonObject = new JSONObject(req.body());
            System.out.println(jsonObject);
            return jsonObject.get("hola");
        });
    }
}