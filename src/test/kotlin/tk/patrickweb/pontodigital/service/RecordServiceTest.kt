package tk.patrickweb.pontodigital.service

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit4.SpringRunner
import tk.patrickweb.pontodigital.document.Record
import tk.patrickweb.pontodigital.repository.RecordRepository
import tk.patrickweb.pontodigital.util.TypeEnum
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

@RunWith(SpringRunner::class)
@SpringBootTest
class RecordServiceTest {

    @MockBean
    private val recordRepository: RecordRepository? = null

    @Autowired
    private val recordService: RecordService? = null

    private val id: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito
                .given<Page<Record>>(recordRepository?.findByEmployeeId(id, PageRequest(0, 10)))
                .willReturn(PageImpl(ArrayList<Record>()))
        //BDDMockito.given(recordRepository?.findByIdOrNull("1")).willReturn(record())
        BDDMockito.given(recordRepository?.save(Mockito.any(Record::class.java)))
                .willReturn(record())
    }

    @Test
    fun testSearchByEmployeeId() {
        val record: Page<Record>? = recordService?.searchByEmployeeId(id, PageRequest(0, 10))
        Assert.assertNotNull(record)
    }

    /*@Test
    fun testSearchById() {
        val record: Record? = recordService?.searchById(id)
        Assert.assertNotNull(record)
    }*/

    @Test
    fun testPersistRecord() {
        val record: Record? = recordService?.persist(record())
        Assert.assertNotNull(record)
    }

    private fun record(): Record = Record(Date(), TypeEnum.BEGIN_JOB, "1", "", "", id)
}