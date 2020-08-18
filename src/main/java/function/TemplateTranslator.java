package function;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.schibsted.spt.data.jslt.JsltException;

import function.model.ExceptionModel;
import function.model.Request;
import function.model.Response;
import function.util.Transform;

import java.io.BufferedWriter;
import java.io.IOException;

public class TemplateTranslator implements HttpFunction {

   @Override
   public void service(HttpRequest request, HttpResponse response) throws IOException {
      BufferedWriter writer = response.getWriter();
      Request request2 = new Gson().fromJson(request.getReader(), Request.class);

      try {
         writer.write(Transform.compile(request2.getInput(), request2.getTemplate()).getResult(response));

      } catch (JsltException ex) {
         ex.printStackTrace();
         writer.write(ExceptionModel.generateError(452, "Incorrect Template", ex).getResult(response));

      }

   }
}