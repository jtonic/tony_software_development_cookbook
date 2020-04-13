package ro.jtonic.handson.micronaut.kt.cli.service

import ro.jtonic.handson.micronaut.kt.cli.model.Customer

interface CustomerService {

  fun getInfo(): Customer
}
