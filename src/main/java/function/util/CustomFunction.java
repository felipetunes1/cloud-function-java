package function.util;

import java.util.ArrayList;
import java.util.List;

import com.schibsted.spt.data.jslt.Function;

public class CustomFunction {

   public static List<Function> getFunctions() {

      List<Function> customFunctions = new ArrayList<>();

      customFunctions.add(new Json2XMLConverter());
      customFunctions.add(new XML2JsonConverter());

      return customFunctions;
      
   }
   
}