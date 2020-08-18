package function.util;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.schibsted.spt.data.jslt.Function;

public class JsltLogger implements Function {

   private static Logger looger = Logger.getLogger("JstlLogger");

   @Override
   public String getName() {
      return "log";
   }

   @Override
   public int getMinArguments() {
      return 1;
   }

   @Override
   public int getMaxArguments() {
      return 1;
   }

   @Override
   public JsonNode call(JsonNode input, JsonNode[] arguments) {

      looger.info(arguments[0].toString());

      return null;
   }
   
}