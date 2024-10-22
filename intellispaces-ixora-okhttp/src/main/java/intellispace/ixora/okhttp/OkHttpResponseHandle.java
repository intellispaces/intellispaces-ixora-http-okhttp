package intellispace.ixora.okhttp;

import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.data.datastream.ByteStreams;
import intellispaces.ixora.data.datastream.MovableByteInputStream;
import intellispaces.ixora.http.HttpStatus;
import intellispaces.ixora.http.HttpStatuses;
import okhttp3.Response;
import okhttp3.ResponseBody;

@ObjectHandle(OkHttpResponseDomain.class)
public abstract class OkHttpResponseHandle implements UnmovableOkHttpResponse {
  private final Response response;
  private final MovableByteInputStream bodyStream;

  OkHttpResponseHandle(Response response) {
    this.response = response;

    ResponseBody body = response.body();
    this.bodyStream = (body != null ? ByteStreams.get(body.byteStream()) : ByteStreams.empty());
  }

  public Response getResponse() {
    return response;
  }

  @Mapper
  @Override
  public HttpStatus status() {
    return HttpStatuses.get(response.code());
  }

  @MapperOfMoving
  @Override
  public MovableByteInputStream bodyStream() {
    return bodyStream;
  }
}
