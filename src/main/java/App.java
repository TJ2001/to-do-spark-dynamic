import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("toDo/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/toDo-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/toDos", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("toDos", ToDo.all());
      model.put("template", "templates/toDo.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/toDo", (request, response) -> {
      Map<String, Object> model  = new HashMap<String, Object>();
      String description = request.queryParams("description");
      ToDo newToDo = new ToDo(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/toDo/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ToDo newToDo = ToDo.find(Integer.parseInt(request.params(":id")));
      model.put("toDo", newToDo);
      model.put("template", "templates/toDo.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
