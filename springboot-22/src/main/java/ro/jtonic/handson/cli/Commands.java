package ro.jtonic.handson.cli;

import javax.validation.constraints.Size;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("CLI commands")
public class Commands {

  @ShellMethod("Greeting someone command")
  public String hello(
      @ShellOption(value = {"--greeting", "-G"}, defaultValue = "Hello Mr.") String greeting,
      @ShellOption(value = {"--to", "-T"}) @Size(min = 3, max = 30) String to) {
    return String.format("%s %s\n", greeting, to);
  }
}
