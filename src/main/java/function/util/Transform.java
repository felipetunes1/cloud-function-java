package function.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.gson.JsonObject;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.JsltException;
import com.schibsted.spt.data.jslt.Parser;

import function.model.Response;

public class Transform {
   public static Response compile(JsonObject input, String template) throws JsltException, IOException {

      Expression expression = null;

      expression = Parser.compileString(template, CustomFunction.getFunctions());

      ObjectMapper objectMapper = new ObjectMapper();

      Response response = new Response();

      JsonNode result = expression.apply(objectMapper.readTree(input.toString()));

      System.out.println(result.toString());
      System.out.println(result.getClass());

      if (result instanceof TextNode)
         response.setTextResult(result.textValue());
      else if (result instanceof DoubleNode)
         response.setTextResult(result.doubleValue());
      else if (result instanceof BooleanNode)
         response.setTextResult(result.booleanValue());
      else if (result instanceof IntNode)
         response.setTextResult(result.intValue());
      else if (result instanceof ObjectNode)
         response.setObjectResult((ObjectNode) result);
      else if (result instanceof ArrayNode)
         response.setArrayResult((ArrayNode) result);

      return response;

   }

}