import static spark.Spark.*;
import org.json.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hola mundo!");

        get("/params", (req, res) -> {
            return req.queryParams("param1");
        });

        post("/", (req, res) -> {
            return req.body();
        });

        put("/json", (req, res) -> {
            JSONObject jsonObject = new JSONObject(req.body());
            System.out.println(jsonObject);
            return jsonObject.get("hola");
        });
    }
}
