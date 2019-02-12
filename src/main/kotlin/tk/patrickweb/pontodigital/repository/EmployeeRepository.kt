package tk.patrickweb.pontodigital.repository

import org.springframework.data.mongodb.repository.MongoRepository
import tk.patrickweb.pontodigital.document.Employee

interface EmployeeRepository : MongoRepository<Employee, String> {

    fun findByEmail(email: String): Employee

    fun findByCpf(cpf: Int): Employee



}
