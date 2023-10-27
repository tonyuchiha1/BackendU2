package structural_pattern.flyweight

class PlayList(private val playListName:String) {
    private var playItems= ArrayList<PlayItem?>()
    fun addPlayItem(songName: String) {
        playItems.add(PlayItemFactory.createPlayItems(songName))
    }

        fun printList(){
            var out = "\n PlayList > $playListName"
            playItems.forEach{ out += "\n\t" + it.toString()}
            println(out)
        }

    }
