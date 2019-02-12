package tk.patrickweb.pontodigital.service.Implementation

import org.springframework.stereotype.Service
import tk.patrickweb.pontodigital.document.Company
import tk.patrickweb.pontodigital.repository.CompanyRepository
import tk.patrickweb.pontodigital.service.CompanyService

@Service
class CompanyServiceImplementation(val companyRepository: CompanyRepository) : CompanyService {

    override fun searchCnpj(cnpj: String): Company? = companyRepository.findByCnpj(cnpj)

    override fun persist(company: Company): Company = companyRepository.save(company)
}