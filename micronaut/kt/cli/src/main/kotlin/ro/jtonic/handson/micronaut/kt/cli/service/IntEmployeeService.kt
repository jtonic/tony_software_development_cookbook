package ro.jtonic.handson.micronaut.kt.cli.service

import ro.jtonic.handson.micronaut.kt.cli.model.Employee
import javax.inject.Singleton

@Singleton
class IntEmployeeService : EmployeeService {

  override fun getByName(name: String)= Employee(name, "ING")
}
