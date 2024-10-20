package intellispace.ixora.okhttp;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import intellispaces.ixora.http.test.OutboundHttpPortTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkHttpPortHandleTest extends OutboundHttpPortTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Test
  public void testHello() {
    MovableOkHttpPort port = OkHttpPorts.get();
    testHello(port.asOutboundHttpPort());
  }

}
