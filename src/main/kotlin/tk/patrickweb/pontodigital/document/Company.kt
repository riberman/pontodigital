package tk.patrickweb.pontodigital.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Company (
    val razaoSocial: String,
    val cnpj: String,
    @Id val id: String? = null
)