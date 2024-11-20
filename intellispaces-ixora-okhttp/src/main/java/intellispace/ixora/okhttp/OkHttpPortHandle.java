package intellispace.ixora.okhttp;

import intellispaces.ixora.http.HttpMethod;
import intellispaces.ixora.http.HttpRequest;
import intellispaces.ixora.http.HttpResponse;
import intellispaces.ixora.http.exception.HttpException;
import intellispaces.ixora.http.exception.HttpExceptions;
import intellispaces.jaquarius.annotation.MapperOfMoving;
import intellispaces.jaquarius.annotation.ObjectHandle;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tech.intellispaces.entity.exception.UnexpectedExceptions;

import java.io.IOException;

@ObjectHandle(OkHttpPortDomain.class)
public abstract class OkHttpPortHandle implements MovableOkHttpPort {
  private final OkHttpClient client;

  public OkHttpPortHandle(OkHttpClient client) {
    this.client = client;
  }

  public OkHttpClient getClient() {
    return client;
  }

  @Override
  @MapperOfMoving
  public HttpResponse exchange(HttpRequest request) throws HttpException {
    Request req = buildRequest(request);
    try {
      Response res = client.newCall(req).execute();
      return OkHttpResponses.get(res).asHttpResponse();
    } catch (IOException e) {
      throw HttpExceptions.withCauseAndMessage(e, "Could not call HTTP server");
    }
  }

  private Request buildRequest(HttpRequest request) {
    Request.Builder reqBuilder = new Request.Builder()
        .url(request.requestURI().toString());
    HttpMethod method = request.method();
    if (method.isGet()) {
      reqBuilder = reqBuilder.get();
    } else {
      throw UnexpectedExceptions.withMessage("Unsupported HTTP method: {}", method.name());
    }
    return reqBuilder.build();
  }
}
