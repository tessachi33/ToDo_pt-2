
import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class ProgramName {
  public static void main(String[] args) {
    // staticFileLocation("/public");
    // String layout = "templates/layout.vtl";
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/home.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    
    // get("/results", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/results.vtl");
    
    //   String something = request.queryParams("something");
    //   String somethingElse = request.queryParams("somethingElse");
    
    //   Integer getMethodName = getMethodName(something, somethingElse);
    
    //   model.put("something", something);
    //   model.put("somethingElse", somethingElse);
    //   model.put("getMethodName", getMethodName(something, somethingElse));
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
  public static Integer getMethodName(String something, String somethingElse){
        String sentence = something.toLowerCase();
        String word = somethingElse.toLowerCase();
        Integer repeats = 0;
        List<String> myList = Arrays.asList(sentence.split(" "));
        
        for(Object temp : myList) {
            if(temp.equals(word)) {
                repeats += 1;
            } 
           
        }


         return repeats;


  }
}
