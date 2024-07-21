fun main(args: Array<String>) {
    var achives: MutableList<Achive> = mutableListOf(Achive("my new achive 1"), Achive("my new achive 22"))
    val startScrean = Screan(
        title = "Список архивов:",
        menu = achives
    )
    var res = startScrean.selectMenuItem()
    while (res != null){
        achives.filter {
            it.name == res
        }.apply { ->
            if (this.isEmpty()) {
                achives.add(Achive(res!!))
                startScrean.menu = achives
            } else {
                var notes: MutableList<Note> = this[0].notes
                val notesScrean = Screan(
                    title = "Список заметок",
                    menu = notes
                )
                var resNotes = notesScrean.selectMenuItem()
                while (resNotes != null)
                {
                    notes.filter {
                        it.name == resNotes
                    }.apply {
                        if (this.isEmpty()){
                            notes.add(Note(
                                name = resNotes!!,
                                text = Utils.getNewItemText("Введите текст заметки")
                            ))
                        } else {
                            println("Текст замеметки с именем : $resNotes")
                            println(this[0].text)
                        }
                    }
                    resNotes = notesScrean.selectMenuItem()
                }
            }
        }
        res = startScrean.selectMenuItem()
    }
}

