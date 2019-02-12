package tk.patrickweb.pontodigital.dto

import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import tk.patrickweb.pontodigital.util.ProfileEnum
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class EmployeeDto (

        @get:NotEmpty(message = "Nome não pode ser nulo.")
        @get:Length(min = 5, max = 65, message = "Nome deve conter entre 5 e 65 caracteres.")
        val name: String,

        @get:NotEmpty(message = "Email não pode ser nulo.")
        @get:Length(min = 5, max = 100, message = "Email deve conter entre 5 e 100 caracteres.")
        @get:Email(message = "Este não é um email válido.")
        val email: String,

        @get:NotEmpty(message = "Senha não pode ser nulo.")
        @get:Length(min = 5, max = 256, message = "Senha deve conter entre 5 e 256 caracteres.")
        val password: String,

        @get:NotEmpty(message = "CPF não pode ser nulo.")
        @get:Length(min = 11, max = 11, message = "CPF deve conter 11 caracteres.")
        val cpf: Int,

        @get:NotEmpty(message = "Perfil de Usuário não pode ser nulo.")
        val profileEnum: ProfileEnum,

        @get:NotEmpty(message = "Empresa não pode ser nulo.")
        val companyId: String,

        val priceHour: Double? = 0.0,

        val workedHour: Float? = 0.0f,

        @Id val id: String? = null
)