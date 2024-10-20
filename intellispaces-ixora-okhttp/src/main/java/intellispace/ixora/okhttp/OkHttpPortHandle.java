package intellispace.ixora.okhttp;

import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.http.HttpRequest;
import intellispaces.ixora.http.HttpResponse;
import intellispaces.ixora.http.exception.HttpException;
import okhttp3.OkHttpClient;

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


    return null;
  }
}
