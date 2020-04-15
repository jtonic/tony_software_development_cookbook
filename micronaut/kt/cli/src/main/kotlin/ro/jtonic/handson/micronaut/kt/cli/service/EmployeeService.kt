package ro.jtonic.handson.micronaut.kt.cli.service

import ro.jtonic.handson.micronaut.kt.cli.model.Employee

interface EmployeeService {

  fun getByName(name: String): Employee
}
