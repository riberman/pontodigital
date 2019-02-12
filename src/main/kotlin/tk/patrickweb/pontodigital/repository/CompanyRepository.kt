package tk.patrickweb.pontodigital.repository

import org.springframework.data.mongodb.repository.MongoRepository
import tk.patrickweb.pontodigital.document.Company

interface CompanyRepository : MongoRepository<Company, String> {

    fun findByCnpj(cnpj: String): Company

}