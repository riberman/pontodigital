package tk.patrickweb.pontodigital.service

import tk.patrickweb.pontodigital.document.Company

interface CompanyService {

    fun searchCnpj(cnpj: String): Company?

    fun persist(company: Company): Company
}