package ro.jtonic.handson.springboot1;

import com.typesafe.config.Config;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.MOCK,
    classes = {MainApp.class}
)
public class TemplatesTest {

  @Autowired
  public Environment env;

  @Test
  public void testProperties() {
    final Config defaultTemplateConf = this.env.getProperty("templates.configuration", Config.class, null);
    System.out.println("defaultTemplateConf = " + defaultTemplateConf);
    final Map<String, Object> values = defaultTemplateConf.root().unwrapped();
    Assertions.assertThat(values).hasSize(3);
  }
}
