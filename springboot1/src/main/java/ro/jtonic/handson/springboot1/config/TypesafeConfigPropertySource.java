package ro.jtonic.handson.springboot1.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;
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
      if (source.getValue(name) instanceof ConfigObject) { //non-leaves
        return source.getConfig(name);
      }
      // instance of ConfigValue (leaves)
      return source.getAnyRef(name);
    }
    return null;
  }
}
