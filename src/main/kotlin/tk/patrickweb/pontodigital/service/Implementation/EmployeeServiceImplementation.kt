package tk.patrickweb.pontodigital.service.Implementation

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tk.patrickweb.pontodigital.document.Employee
import tk.patrickweb.pontodigital.repository.EmployeeRepository
import tk.patrickweb.pontodigital.service.EmployeeService

@Service
class EmployeeServiceImplementation(val employeeRepository: EmployeeRepository): EmployeeService {

    //override fun searchId(id: String): Employee? = employeeRepository.findByIdOrNull(id)

    override fun searchCpf(cpf: Int): Employee? = employeeRepository.findByCpf(cpf)

    override fun searchEmail(email: String): Employee? = employeeRepository.findByEmail(email)

    override fun persist(employee: Employee): Employee = employeeRepository.save(employee)
}