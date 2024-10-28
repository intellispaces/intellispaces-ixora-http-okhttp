package intellispace.ixora.okhttp;

import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;
import intellispaces.ixora.http.HttpResponseDomain;

@Domain("3cd2df0d-a248-408f-9c39-5cee9d504415")
public interface OkHttpResponseDomain extends HttpResponseDomain {

  @Channel("c46f03c6-05d9-4034-b0df-9ec634d3c62b")
  HttpResponseDomain asHttpResponse();
}
