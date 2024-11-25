package tech.intellispace.ixora.okhttp;

import tech.intellispaces.ixora.http.MovableOutboundHttpPort;
import tech.intellispaces.ixora.http.test.OutboundHttpPortTest;
import tech.intellispaces.jaquarius.system.Modules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkHttpPortHandleTest extends OutboundHttpPortTest {

  @BeforeEach
  public void init() {
    Modules.get().start();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Override
  protected MovableOutboundHttpPort getPort() {
    return OkHttpPorts.get().asOutboundHttpPort();
  }

  @Test
  public void testHello() {
    super.testHello();
  }
}
