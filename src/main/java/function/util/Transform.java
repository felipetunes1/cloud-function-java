package function.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

import function.model.Response;

public class Transform {
   public static Response compile(JsonObject input, String template) {

      Expression expression = null;

      expression = Parser.compileString(template);

      ObjectMapper objectMapper = new ObjectMapper();

      Response response = new Response();

      try {
         response.setResult((ObjectNode)expression.apply(objectMapper.readTree(input.toString())));
      } catch (IOException e) {
         e.printStackTrace();
      }
      return response;

   }

}