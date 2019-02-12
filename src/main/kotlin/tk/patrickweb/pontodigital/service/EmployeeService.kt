package tk.patrickweb.pontodigital.service

import tk.patrickweb.pontodigital.document.Employee

interface EmployeeService {

    //fun searchId(id: String): Employee?

    fun searchCpf(cpf: Int): Employee?

    fun searchEmail(email: String): Employee?

    fun persist(employee: Employee): Employee
}