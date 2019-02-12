package tk.patrickweb.pontodigital.service.Implementation

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tk.patrickweb.pontodigital.document.Record
import tk.patrickweb.pontodigital.repository.RecordRepository
import tk.patrickweb.pontodigital.service.RecordService

@Service
class RecordServiceImplementation(val recordRepository: RecordRepository) : RecordService {

    override fun searchByEmployeeId(employeeId: String, pageRequest: PageRequest): Page<Record> = recordRepository.findByEmployeeId(employeeId, pageRequest)

    override fun searchById(id: String): Record? = recordRepository.findByIdOrNull(id)

    override fun persist(record: Record): Record = recordRepository.save(record)

    override fun delete(id: String) = recordRepository.deleteById(id)
}