package tk.patrickweb.pontodigital.dto

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

data class CompanyDto (
        @get:NotEmpty(message = "Razão Social não pode ser nulo.")
        @get:Length(min = 5, max = 65, message = "Razão Social deve conter entre 5 e 65 caracteres.")
        val razaoSocial: String = "",

        @get:NotEmpty(message = "CNPJ não pode ser nulo.")
        @get:Length(min = 0, max = 14, message = "CNPJ deve conter 14 caracteres.")
        val cnpj: String = "",


        val id: String? = null
)