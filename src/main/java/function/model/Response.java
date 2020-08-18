package function.model;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.cloud.functions.HttpResponse;

public class Response {

   private JsonObject objectResult;

   private Object result;

   private JsonArray arrayResult;

   public String getResult(HttpResponse response) {
      Gson gson = new Gson();
      response.setStatusCode(200);
      response.setContentType("application/json");

      if (objectResult != null) {
         return gson.toJson(objectResult);

      } else if (result != null) {
         return gson.toJson(this);

      } else if (arrayResult != null) {
         return gson.toJson(arrayResult);

      }
      return ExceptionModel.generateError(452, "Result Nullable", "Template Execution Returned a Null Result").getResult(response);
   }

   public JsonObject getObjectResult() {
      return objectResult;
   }

   public void setObjectResult(ObjectNode result) {
      Gson gson = new Gson();
      this.objectResult = gson.fromJson(result.toString(), JsonObject.class);
   }

   public void setTextResult(Object textResult) {
      this.result = textResult;
   }

   public Object getTextResult() {
      return result;
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
      return "Response [arrayResult=" + arrayResult + ", objectResult=" + objectResult + ", textResult=" + result
            + "]";
   }


}