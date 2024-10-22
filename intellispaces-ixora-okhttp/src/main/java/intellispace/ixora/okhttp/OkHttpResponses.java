package intellispace.ixora.okhttp;

import okhttp3.Response;

public interface OkHttpResponses {

  static UnmovableOkHttpResponse of(Response response) {
    return new OkHttpResponseHandleImpl(response);
  }
}
