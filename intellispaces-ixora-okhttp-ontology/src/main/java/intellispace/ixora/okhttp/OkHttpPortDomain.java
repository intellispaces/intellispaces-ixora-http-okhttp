package intellispace.ixora.okhttp;

import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;
import intellispaces.ixora.http.OutboundHttpPortDomain;

@Domain("6ac6a0f8-9909-46f4-aeb2-4ef8e1c46c62")
public interface OkHttpPortDomain extends OutboundHttpPortDomain {

  @Channel("0202b98a-5e09-49c2-b1a3-316bf13115e9")
  OutboundHttpPortDomain asOutboundHttpPort();
}
