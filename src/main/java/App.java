
import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   // get(/) type of route get this url..


//dont need to display all tasks independently of parent category
  //  get("/tasks", (request, response) -> {
  //    HashMap<String, Object> model = new HashMap<String, Object>();
  //    model.put("tasks", Task.all());
  //    model.put("template", "templates/tasks.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
    //After they submit the form, this is where they will be taken /tasks.vtl

  //  get("tasks/new", (request, response) -> {
  //    HashMap<String, Object> model = new HashMap<String, Object>();
  //    model.put("template", "templates/task-form.vtl");
  //    return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());
  //  //task-form is where client inputs data and hits submit

   post("/tasks", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
     String description = request.queryParams("description");
     Task newTask = new Task(description);
     category.addTask(newTask);
     model.put("category", category);
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   //grabs information and makes a new description of the information in the array
   //takes you to a new page

   get("/tasks/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Task task = Task.find(Integer.parseInt(request.params(":id")));
     model.put("task", task);
     model.put("template", "templates/task.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/categories", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("categories", Category.all());
     model.put("template", "templates/categories.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/categories/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/category-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/categories", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     String name = request.queryParams("name");
     Category newCategory = new Category(name);
     model.put("category", newCategory);
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/categories/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("category", Category.find(Integer.parseInt(request.params(":id"))));
     model.put("template", "templates/category.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/categories/:id/tasks/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("category", Category.find(Integer.parseInt(request.params(":id"))));
     model.put("template", "templates/category-tasks-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


  }//end of main
}//end of class
