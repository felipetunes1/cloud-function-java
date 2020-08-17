package function.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Response {

   private JsonObject result;

   public JsonObject getResult() {
      return result;
   }

   public void setResult(ObjectNode result) {
      Gson gson = new Gson();
      this.result = gson.fromJson(result.toString(), JsonObject.class);
   }

   @Override
   public String toString() {
      return "Response [result=" + result + "]";
   }

   
   
}