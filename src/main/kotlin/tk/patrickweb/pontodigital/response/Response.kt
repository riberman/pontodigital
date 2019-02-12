package tk.patrickweb.pontodigital.response

data class Response<T> (
        val errors: ArrayList<String> = arrayListOf(),
        var data: T? = null
)
