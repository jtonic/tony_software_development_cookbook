package ro.jtonic.handson.springboot1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.MOCK,
    classes = {MainApp.class},
    properties = {"application.description:My application"}
)
public class MainAppTest {

  @Value("${application.name}")
  public String applicationName;

  @Value("${application.description}")
  public String applicationDescription;

  @Value("${application.port:9090}")
  public String applicationPort;

  @Autowired
  public Environment env;

  @Test
  public void testProperties() {
    assertEquals("Jtonic", this.applicationName);
    assertEquals("My application", this.applicationDescription);
    assertEquals("8081", this.applicationPort);
    assertEquals("8081", this.env.getProperty("application.port", "9090"));
  }
}
