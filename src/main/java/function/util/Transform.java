package function.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.schibsted.spt.data.jslt.JsltException;
import com.schibsted.spt.data.jslt.Parser;

import function.model.Response;

public class Transform {
   public static Response compile(JsonObject input, String template) throws JsltException, IOException {
      return Response.build(Parser.compileString(template, CustomFunction.getFunctions())
                                  .apply(new ObjectMapper().readTree(input.toString())));
   }

}