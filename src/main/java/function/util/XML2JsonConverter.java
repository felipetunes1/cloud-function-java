package function.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.underscore.lodash.U;
import com.schibsted.spt.data.jslt.Function;

public class XML2JsonConverter implements Function {

   @Override
   public String getName() {
      return "xml2Json";
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
      ObjectMapper objectMapper = new ObjectMapper();
      try {
         return objectMapper.readTree(U.xmlToJson(arguments[0].asText()).toString());
      } catch (JsonMappingException e) {
         e.printStackTrace();
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
		return null;
   }

}