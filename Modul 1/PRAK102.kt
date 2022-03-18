fun main() {

    println("Masukkan nilai x : ")
    val x = readLine()!!.toInt()
    fungsi(x)
}

fun fungsi(x: Int){
    val fx = 2 * x * x + 5 * x - 8
    println(fx)
}