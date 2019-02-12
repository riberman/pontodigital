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
import tk.patrickweb.pontodigital.document.Company
import tk.patrickweb.pontodigital.repository.CompanyRepository

@RunWith(SpringRunner::class)
@SpringBootTest
class CompanyServiceTest {

    @Autowired
    val companyService: CompanyService? = null

    @MockBean
    private val companyRepository: CompanyRepository? = null

    private val cnpj = "05734512308"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(companyRepository?.findByCnpj(cnpj)).willReturn(company())
        BDDMockito.given(companyRepository?.save(company())).willReturn(company())
    }

    @Test
    fun testSearchCompanyByCnpj() {
        val company: Company? = companyService?.searchCnpj(cnpj)
        Assert.assertNotNull(company)
    }

    @Test
    fun testPersistCompany() {
        val company: Company? = companyService?.persist(company())
        Assert.assertNotNull(company)
    }

    private fun company(): Company = Company("Razão Social",  cnpj)
}