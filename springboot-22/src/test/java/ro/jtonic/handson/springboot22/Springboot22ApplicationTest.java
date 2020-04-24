package ro.jtonic.handson.springboot22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

/*
  Demoing the yaml shortcomings - @TestPropertySource("classpath:/application-test.yml")
  https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-yaml-shortcomings
 */

@SpringBootTest
@TestPropertySource("classpath:/application-test.yml")
class Springboot22ApplicationTest {

  @Value("${jtonic.handson.app.name}")
  private String appName;

  // @Value("${jtonic.handson.app.description}")
  // private String appDescription;

  @Autowired
  private Environment env;

	@Test
	void testApplicationConfiguration() {
	  assertThat(appName)
        .isNotNull()
        .isEqualTo("SpringBoot 2.2 example");

	  // assertThat(appDescription)
    //     .isNotNull();

	  assertThat(env.getProperty("jtonic.handson.app.name"))
        .isNotNull()
        .isEqualTo("SpringBoot 2.2 example");

	  assertThat(env.getProperty("jtonic.handson.app.description"))
        .isNull();
	}
}
