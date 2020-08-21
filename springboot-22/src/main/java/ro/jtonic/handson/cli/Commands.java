package ro.jtonic.handson.cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("CLI commands")
public class Commands {

  @Autowired
  private ObjectMapper mapper;

  @ShellMethod("Greeting someone command")
  public String hello(
      @ShellOption(value = {"--greeting", "-G"}, defaultValue = "Hello Mr.") String greeting,
      @ShellOption({"--to", "-T"}) @Size(min = 3, max = 30) String to,
      @ShellOption("--template-params") @JSonContentConstraint String templateParams
  ) {

    try {
      final TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {
      };
      final Map<String, String> templateParamsMap = mapper.readValue(templateParams, typeReference);
      if(templateParamsMap.isEmpty()) {
        System.out.println("[WARN] No template params passed!!!");
      } else {
        System.out.printf("[INFO] Template's params: %s\n", templateParamsMap.toString());
      }
    } catch (JsonProcessingException e) {
      return "Cannot parse the template params. They should be passed in a JSON format.";
    }
    return String.format("%s %s. Message params: %s\n", greeting, to, templateParams);
  }
}
