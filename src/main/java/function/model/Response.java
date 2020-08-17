package function.model;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.cloud.functions.HttpResponse;

public class Response {

   private JsonObject objectResult;

   private String textResult;

   private JsonArray arrayResult;

   public String getResult(HttpResponse response) {
      Gson gson = new Gson();
      response.setStatusCode(200);

      if (objectResult != null) {
         response.setContentType("application/json");
         return gson.toJson(objectResult);

      } else if (textResult != null) {
         return textResult;

      } else if (arrayResult != null) {
         response.setContentType("application/json");
         return gson.toJson(arrayResult);

      }
      response.setStatusCode(500);
      return null;
   }

   public JsonObject getObjectResult() {
      return objectResult;
   }

   public void setObjectResult(ObjectNode result) {
      Gson gson = new Gson();
      this.objectResult = gson.fromJson(result.toString(), JsonObject.class);
   }

   public void setTextResult(String textResult) {
      this.textResult = textResult;
   }

   public String getTextResult() {
      return textResult;
   }

   public void setArrayResult(ArrayNode arrayResult) {
      Gson gson = new Gson();
      this.arrayResult = gson.fromJson(arrayResult.toString(), JsonArray.class);
   }

   public JsonArray getArrayResult() {
      return arrayResult;
   }

   @Override
   public String toString() {
      return "Response [arrayResult=" + arrayResult + ", objectResult=" + objectResult + ", textResult=" + textResult
            + "]";
   }


}