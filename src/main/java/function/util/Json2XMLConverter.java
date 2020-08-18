package function.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.underscore.lodash.U;
import com.schibsted.spt.data.jslt.Function;

public class Json2XMLConverter implements Function {

   @Override
   public String getName() {
      return "json2Xml";
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
      return TextNode.valueOf(U.jsonToXml(arguments[0].toString()));
   }
   
}