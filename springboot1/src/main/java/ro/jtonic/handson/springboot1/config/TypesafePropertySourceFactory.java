package ro.jtonic.handson.springboot1.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class TypesafePropertySourceFactory implements PropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource resource) {
    final String configFile = resource.getResource().getFilename();
    Config config = ConfigFactory.load(configFile).resolve();

    String safeName = name == null ? "typeSafe" : name;
    return new TypesafeConfigPropertySource(safeName, config);
  }
}
