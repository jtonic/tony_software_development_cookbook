package ro.jtonic.handson.cli;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class CliApp {

	public static void main(String[] args) {

	  String[] disabledCommands = {"--spring.shell.command.stacktrace.enabled=false"};
    String[] fullArgs = StringUtils.concatenateStringArrays(args, disabledCommands);

		new SpringApplicationBuilder(CliApp.class)
        .bannerMode(Mode.OFF)
        .run(fullArgs);
	}
}
