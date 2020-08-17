package function;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;

import function.model.Request;
import function.model.Response;
import function.util.Transform;

import java.io.BufferedWriter;
import java.io.IOException;

public class TemplateTranslator implements HttpFunction {
  // Simple function to return "Hello World"
  @Override
  public void service(HttpRequest request, HttpResponse response)
      throws IOException {
    BufferedWriter writer = response.getWriter();
    Gson gson = new Gson();
    
    Request request2 = gson.fromJson(request.getReader(), Request.class);

    System.out.println(request2);
    Response result = Transform.compile(request2.getInput(), request2.getTemplate());

    System.out.println(result.toString());
    response.setContentType("application/json");
    response.setStatusCode(200);
    writer.write(gson.toJson(result));
  }
}