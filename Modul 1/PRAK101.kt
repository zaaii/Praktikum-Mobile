fun main() {
    print("Waktu sekarang: ")
    val waktu = readLine()
    print("Nama Anda: ")
    val nama = readLine()
    print("Umur Anda: ")
    val umur = readLine()
    print("Suhu Tubuh Anda: ")
    val suhu = (35 .. 37).random().toFloat()

    val output ="""
        
        Selamat $waktu, $nama.
        Umur Anda $umur tahun.
        Suhu tubuh Anda $suhu derajat celcius..
    """.trimIndent()
    println(output)
}