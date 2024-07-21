class Screan<T : Menuable> (
    val title: String,
    var menu: List<T>
) {
    fun showMenu(){
        println(title)
        println("0. Создать")
        menu.forEachIndexed(
            action = {index, s ->
                println("${index + 1}. ${s.name}")
            }
        )
        println("${menu.size + 1}. Выход")
    }

    fun selectMenuItem(): String? {
        while (true) {
            showMenu()
            Utils.getNewItemText("").toIntOrNull().let {
                if (it == null){
                    println("Необходимо вводить только цифру")
                } else {
                    if (it in 0..menu.size + 1)
                    {
                        if (it == 0) {
                            return Utils.getNewItemText("Введите название")
                        } else if (it == menu.size + 1) {
                            return null
                        } else {
                            return menu[it-1].name
                        }
                    } else {
                        println("Такого пункта меню нет")
                    }
                }
            }
        }
    }

}