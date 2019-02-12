package tk.patrickweb.pontodigital.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import tk.patrickweb.pontodigital.util.TypeEnum
import java.util.Date

@Document
data class Record (
    val date: Date,
    val type: TypeEnum,
    val employeeId: String,
    val description: String? = "",
    val location: String? = "",
    @Id val id: String? = null
)
