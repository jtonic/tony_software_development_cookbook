package ro.jtonic.handson.springboot1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.MOCK,
    properties = {"application.description:My application"}
)
public class MainAppTest {

  @Value("${application.name}")
  public String applicationName;

  @Value("${application.description}")
  public String applicationDescription;

  @Test
  public void testProperties() {
    assertEquals("Jtonic", this.applicationName);
    assertEquals("My application", this.applicationDescription);
  }
}
