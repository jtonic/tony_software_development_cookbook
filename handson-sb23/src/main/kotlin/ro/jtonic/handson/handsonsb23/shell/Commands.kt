package ro.jtonic.handson.handsonsb23.shell

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import javax.validation.constraints.Size

@ShellComponent
class Commands constructor(@Autowired val mapper: ObjectMapper) {

  @ShellMethod("Greeting someone command")
  fun hello(
    @ShellOption(value = ["--greeting", "-G"], defaultValue = "Hello Mr.") greeting: String,
    @ShellOption("--to", "-T") to: @Size(min = 3, max = 30) String,
    @ShellOption("--template-params") templateParams: String
  ): String? {
    try {
      val typeReference: TypeReference<Map<String, String>> = object : TypeReference<Map<String, String>>() {}
      val templateParamsMap: Map<String, String> = mapper.readValue(templateParams, typeReference)
      if (templateParamsMap.isEmpty()) {
        println("[WARN] No template params passed!!!")
      } else {
        System.out.printf("[INFO] Template's params: %s\n", templateParamsMap.toString())
      }
    } catch (e: JsonProcessingException) {
      return "Cannot parse the template params. They should be passed in a JSON format."
    }
    return String.format("%s %s. Message params: %s\n", greeting, to, templateParams)
  }
}