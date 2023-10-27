package structural_pattern.flyweight

class PlayItemFactory {
    companion object{//metodos estatitcos de java,para acceder sin un instruccio previa
        private const val ENABLE_FLY_WEIGHT= true
        private val playItems = hashMapOf<String,PlayItem>()
        private var idSequence=0L

        fun createPlayItems(songName: String): PlayItem?{
            return if (ENABLE_FLY_WEIGHT && playItems.containsKey(songName)){
                playItems[songName]
            }else{
                val playItem = PlayItem(++idSequence,songName.uppercase())
                playItems[songName] = playItem
                        playItem
            }

        }
    }
}