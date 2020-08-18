package function.model;

import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;

public class ExceptionModel {

   private int code;
   private String message;
   private String description;

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public static ExceptionModel generateError(int code, String message, String description) {
      ExceptionModel exceptionModel = new ExceptionModel();
      exceptionModel.setCode(code);
      exceptionModel.setMessage(message);
      exceptionModel.setDescription(description);

      return exceptionModel;

   }

   public String getResult(HttpResponse response) {
      response.setStatusCode(452);
      return new Gson().toJson(this);
   }

}