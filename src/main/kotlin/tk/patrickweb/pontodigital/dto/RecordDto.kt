package tk.patrickweb.pontodigital.dto

import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import tk.patrickweb.pontodigital.util.TypeEnum
import java.util.*
import javax.validation.constraints.NotEmpty

data class RecordDto (

        @get:NotEmpty(message = "Data não pode ser nulo.")
        val date: Date,

        @get:NotEmpty(message = "Tipo de Registro não pode ser nulo.")
        val type: TypeEnum,

        @get:NotEmpty(message = "Empresa não pode ser nulo.")
        val employeeId: String,

        @get:Length(max = 255, message = "Nome deve conter no máximo 245 caracteres.")
        val description: String? = "",

        val location: String? = "",

        @Id val id: String? = null
)