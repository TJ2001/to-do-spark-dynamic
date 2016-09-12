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
      model.put("todos", request.session().attribute("todos"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/todo", (request, response) -> {
      Map<String, Object> model  = new HashMap<String, Object>();
      ArrayList<ToDo> todos = request.session().attribute("todos");
      if (todos == null) {
        todos = new ArrayList<ToDo>();
        request.session().attribute("todos", todos);
      }
      String description = request.queryParams("description");
      ToDo newToDo = new ToDo(description);
      todos.add(newToDo);
      request.session().attribute("todo", newToDo);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
