package ru.stqa.layers.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import ru.stqa.layers.app.Application;

public class TestBase {

  protected static final Application app = new Application();

  @BeforeClass
  public static void setUp() throws Exception {
    app.init();
  }

  @AfterClass
  public static void tearDown() {
    app.stop();
  }

}
