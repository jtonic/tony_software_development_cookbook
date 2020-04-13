package ro.jtonic.handson.micronaut.kt.cli.service

import ro.jtonic.handson.micronaut.kt.cli.model.Customer
import java.util.UUID

class IngCustomerService : CustomerService {

  override fun getInfo() =
    Customer("Antonel-Ernest Pazargic", 18, UUID.randomUUID());
}
