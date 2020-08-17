package function.model;

import com.google.gson.JsonObject;

/**
 * User
 */
public class Request {

   private JsonObject input;
   private String template;

   public JsonObject getInput() {
      return input;
   }

   public void setInput(JsonObject input) {
      this.input = input;
   }

   public String getTemplate() {
      return template;
   }

   public void setTemplate(String template) {
      this.template = template;
   }

   @Override
   public String toString() {
      return "Request [input=" + input + ", template=" + template + "]";
   }

   

   
}