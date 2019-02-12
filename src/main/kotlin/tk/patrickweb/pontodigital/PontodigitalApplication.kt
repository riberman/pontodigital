package tk.patrickweb.pontodigital

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import tk.patrickweb.pontodigital.document.Company
import tk.patrickweb.pontodigital.document.Employee
import tk.patrickweb.pontodigital.repository.CompanyRepository
import tk.patrickweb.pontodigital.repository.EmployeeRepository
import tk.patrickweb.pontodigital.repository.RecordRepository
import tk.patrickweb.pontodigital.util.PasswordUtil
import tk.patrickweb.pontodigital.util.ProfileEnum

@SpringBootApplication
class PontodigitalApplication(val companyRepository: CompanyRepository, val employeeRepository: EmployeeRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		companyRepository.deleteAll()
		employeeRepository.deleteAll()

		val company: Company = companyRepository.save(Company("Empresa Patrick",  "6800204000108"))

		val administrator: Employee = employeeRepository.save(Employee("Administrador", "admin@teste.com", PasswordUtil().generateBcrypt("123456789"), 1231231231, ProfileEnum.ROLE_ADMIN, company.id!!))

		val employee: Employee = employeeRepository.save(Employee("Funcionario", "patrick@teste.com", PasswordUtil().generateBcrypt("123456789"), 1231231231, ProfileEnum.ROLE_USER, company.id!!))

		System.out.println("Empresa: " + company.id)
		System.out.println("Administrador " + administrator.id)
		System.out.println("Funcionario " + employee.id)
	}
}

fun main(args: Array<String>) {
	runApplication<PontodigitalApplication>(*args)
}

