package ro.jtonic.handson.micronaut.cli.generated;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller("/person")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @Get("/fathername")
  public String index() {
    return this.personService.getFatherName();
  }
}
