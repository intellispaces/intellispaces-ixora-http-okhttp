package tech.intellispace.ixora.okhttp;

import tech.intellispaces.ixora.data.datastream.ByteStreams;
import tech.intellispaces.ixora.data.datastream.MovableByteInputStream;
import tech.intellispaces.ixora.http.HttpStatus;
import tech.intellispaces.ixora.http.HttpStatuses;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.MapperOfMoving;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;
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

  @Override
  public void release() {
    response.close();
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
