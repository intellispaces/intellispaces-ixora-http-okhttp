package tech.intellispace.ixora.okhttp;

import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Data;
import tech.intellispaces.jaquarius.annotation.Domain;

@Data
@Domain("5204a412-8e80-4fdf-a349-ccef70c8fe58")
public interface OkHttpPortPropertiesDomain {

  @Channel("aba3acfc-960f-4e7a-bc5e-f5e5cef88e14")
  Integer connectTimeoutMs();

  @Channel("adc31a43-a5ac-4e34-8938-fb262ea141f0")
  Integer readTimeoutMs();

  @Channel("8e075899-efe5-4eca-98d7-0879ad729291")
  Integer writeTimeoutMs();
}
