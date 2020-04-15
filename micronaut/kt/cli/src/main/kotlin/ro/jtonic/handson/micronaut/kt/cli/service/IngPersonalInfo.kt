package ro.jtonic.handson.micronaut.kt.cli.service

import ro.jtonic.handson.micronaut.kt.cli.annotation.ING
import ro.jtonic.handson.micronaut.kt.cli.model.Employee
import javax.inject.Singleton

@Singleton
class IngPersonalInfo (@ING private val employeeService: EmployeeService) {

  fun getInfo(personName: String): Employee = employeeService.getByName(personName)
}
