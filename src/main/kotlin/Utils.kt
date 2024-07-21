import java.util.Scanner

object Utils {
    fun getNewItemText(title: String): String {
        if (title.isNotEmpty())
            println(title)
        while (true) {
            Scanner(System.`in`).nextLine().let {
                if (it.isEmpty())
                    println("Ввод должен быть не пустой")
                else
                    return it
            }
        }
    }

}