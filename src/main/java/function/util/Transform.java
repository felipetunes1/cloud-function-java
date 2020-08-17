package function.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
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
         JsonNode result = expression.apply(objectMapper.readTree(input.toString()));
         if (result instanceof TextNode)
            response.setTextResult(result.textValue());
         else if(result instanceof ObjectNode)
            response.setObjectResult((ObjectNode) result);
         else if(result instanceof ArrayNode)
            response.setArrayResult((ArrayNode) result);

      } catch (IOException e) {
         e.printStackTrace();
      }
      return response;

   }

}