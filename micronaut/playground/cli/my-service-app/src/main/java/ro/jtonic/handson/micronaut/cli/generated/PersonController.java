package ro.jtonic.handson.micronaut.cli.generated;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/person")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @Get(produces = "text/plain")
  public String index() {
    return this.personService.getFatherName();
  }
}
