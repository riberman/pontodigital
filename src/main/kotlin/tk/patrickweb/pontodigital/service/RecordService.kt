package tk.patrickweb.pontodigital.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import tk.patrickweb.pontodigital.document.Record

interface RecordService {

    fun searchByEmployeeId(employeeId: String, pageRequest: PageRequest): Page<Record>

    fun searchById(id: String): Record?

    fun persist(record: Record): Record

    fun delete(id: String)

}