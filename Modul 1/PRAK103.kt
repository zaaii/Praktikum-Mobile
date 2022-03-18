fun main() {
//    sebuah program yang dapat menampilkan 5 bilangan kelipatan dari bilangan yang telah diinput dan habis dibagi 2 atau 3.
    println("Masukkan bilangan : ")
    var bil = readLine()!!.toInt()
    var kel = bil

for (i in 1..7) {
    bil += kel
    if(bil%2==0 || bil%3==0) {
        println(bil)
        }
    }
}