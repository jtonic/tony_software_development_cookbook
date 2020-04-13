package ro.jtonic.handson.micronaut.kt.cli.service

import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class CustomerFactory {

  @Singleton
  fun customerService(): CustomerService = IngCustomerService()
}
