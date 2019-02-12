package tk.patrickweb.pontodigital.service

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import tk.patrickweb.pontodigital.document.Employee
import tk.patrickweb.pontodigital.repository.EmployeeRepository
import tk.patrickweb.pontodigital.util.PasswordUtil
import tk.patrickweb.pontodigital.util.ProfileEnum

@RunWith(SpringRunner::class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    val employeeService: EmployeeService? = null

    @MockBean
    val employeeRepository: EmployeeRepository? = null

    private val cpf: Int = 543123123

    private val email: String = "teste@teste.com"

    private val id: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //BDDMockito.given(employeeRepository?.findOne(id)).willReturn(employee())
        BDDMockito.given(employeeRepository?.findByCpf(cpf)).willReturn(employee())
        BDDMockito.given(employeeRepository?.findByEmail(email)).willReturn(employee())
        BDDMockito.given(employeeRepository?.save(employee())).willReturn(employee())
    }

    @Test
    fun testSearchEmployeeByCpf() {
        val employee: Employee? = employeeService?.searchCpf(cpf)
        Assert.assertNotNull(employee)
    }

    @Test
    fun testSearchByEmployeeByEmail() {
        val employee: Employee? = employeeService?.searchEmail(email)
        Assert.assertNotNull(employee)
    }

    @Test
    fun testPersistEmployee() {
        val employee: Employee? = employeeService?.persist(employee())
        Assert.assertNotNull(employee)
    }

    private fun employee(): Employee = Employee("Pessoa", "teste@teste.com", "123456789", cpf, ProfileEnum.ROLE_ADMIN, "1", null, null, "1")
}