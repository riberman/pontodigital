package tk.patrickweb.pontodigital.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import tk.patrickweb.pontodigital.document.Employee
import tk.patrickweb.pontodigital.document.Record

interface RecordRepository : MongoRepository<Record, String>{

    fun findByEmployeeId(employeeId: String, pageRequest: PageRequest): Page<Record>
}