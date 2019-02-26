package com.contraslash.java;

import static spark.Spark.*;

import org.javalite.activejdbc.LazyList;
import org.json.*;



public class HelloWorld {
    public static void main(String[] args) {
        get("/", (req, res) -> {

            TareaDAO tareaDAO = new TareaDAO();
             return ((LazyList<Tarea>)(tareaDAO.todos())).toJson(true);

            }
        );

        get("/params", (req, res) -> {
            return req.queryParams("param1");
        });

        post("/", (req, res) -> {

            // com.contraslash.java.Tarea tarea = new Gson().fromJson(req.body(), com.contraslash.java.Tarea.class);
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
