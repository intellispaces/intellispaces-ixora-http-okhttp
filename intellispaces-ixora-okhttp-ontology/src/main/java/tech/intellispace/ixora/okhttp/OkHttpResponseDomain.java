package tech.intellispace.ixora.okhttp;

import tech.intellispaces.ixora.http.HttpResponseDomain;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;

@Domain("3cd2df0d-a248-408f-9c39-5cee9d504415")
public interface OkHttpResponseDomain extends HttpResponseDomain {

  @Channel("c46f03c6-05d9-4034-b0df-9ec634d3c62b")
  HttpResponseDomain asHttpResponse();
}
