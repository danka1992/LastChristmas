import java.io.File

class SectionsCleaning {

    private fun readFile() : List<String> {
        val fileName = "src/main/resources/sectionsToClean.txt"
        return File(fileName).readLines()
    }

    private fun saveIntoPairs() : List<Pair<IntRange, IntRange>> {
        val file = readFile()
        val pair = mutableListOf<Pair<IntRange, IntRange>>()
        file.forEachIndexed { index, s ->
            //val ranges = s.split(",")
            //ranges.forEach {
                val numbers = s.split("-", ",")
                pair.add(
                    Pair(
                        IntRange(numbers[0].toInt(), numbers[1].toInt()),
                        IntRange(numbers[2].toInt(), numbers[3].toInt())
                    )
                )
            }
            //pair.add()
        //}
        return pair
    }

    fun findAllPairsThatContainsOneAnother() {
        val pair = saveIntoPairs()
        var counter = 0
        pair.forEach {
            if((it.first.first <= it.second.first && it.first.last >= it.second.last) ||
                (it.first.first >= it.second.first && it.first.last <= it.second.last))
                counter += 1
        }
        println("$counter pairs fully contain the other")
    }
}