package ro.jtonic.handson.springboot1.config;

import com.typesafe.config.Config;
import org.springframework.core.env.PropertySource;

public class TypesafeConfigPropertySource extends PropertySource<Config> {

  public TypesafeConfigPropertySource(String name, Config source) {
    super(name, source);
  }

  @Override
  public Object getProperty(String name) {
    if (name.contains("["))
      return null;
    if (name.contains(":"))
      return null;
    if (source.hasPath(name)) {
      return source.getAnyRef(name);
    }
    return null;
  }
}
