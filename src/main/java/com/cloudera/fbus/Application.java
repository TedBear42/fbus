package com.cloudera.fbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  private static final Logger logger = LoggerFactory
      .getLogger(Application.class);
  private static final String configLocation = "classpath:fbus.xml";

  public static void main(String[] args) {
    Application app;

    app = new Application();

    try {
      app.run(args);
    } catch (Throwable t) {
      logger.error("Caught exception - {}", t.getMessage());
      logger.debug("Trace follows.", t);
    }
  }

  public void run(String[] args) {
    AbstractApplicationContext context;

    context = new ClassPathXmlApplicationContext(configLocation);

    context.registerShutdownHook();
  }

}
