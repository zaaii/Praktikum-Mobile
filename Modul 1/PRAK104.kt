class Pekerjaan(val namapekerjaan: String = "PNS", val gaji: Int = 3_000_000, val tempat: String = "Banjarmasin") {
    fun tampil() {
        val cetak = """
            Nama Pekerjaan : $namapekerjaan
            Gaji : $gaji
            Tempat : $tempat
        """.trimIndent()
        println(cetak)
    }
}

fun main() {
    val pekerjaan = Pekerjaan()
    pekerjaan.tampil()
}