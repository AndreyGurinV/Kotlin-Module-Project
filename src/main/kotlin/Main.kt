fun main(args: Array<String>) {
    val achives: MutableList<Achive> = mutableListOf()
    val startScrean = Screan(
        title = "Список архивов:",
        menu = achives,
        createNewText = "Введите название нового архива"
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
                val notes: MutableList<Note> = this[0].notes
                val notesScrean = Screan(
                    title = "Список заметок",
                    menu = notes,
                    createNewText = "Введите название новой заметки"
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
                            println("\n")
                        }
                    }
                    resNotes = notesScrean.selectMenuItem()
                }
            }
        }
        res = startScrean.selectMenuItem()
    }
}

