package tk.patrickweb.pontodigital.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import tk.patrickweb.pontodigital.util.ProfileEnum

@Document
data class Employee (
    val name: String,
    val email: String,
    val password: String,
    val cpf: Int,
    val profileEnum: ProfileEnum,
    val companyId: String,
    val priceHour: Double? = 0.0,
    val workedHour: Float? = 0.0f,
    @Id val id: String? = null
)