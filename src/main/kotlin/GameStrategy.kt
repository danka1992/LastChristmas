import java.io.File

class GameStrategy {
    fun countTotalSecondPart(){
        val fileName = "src/main/resources/pairs.txt"
        val lines: List<String> = File(fileName).readLines()
        val pairs: MutableList<Pair<Char, Char>> = mutableListOf()
        lines.forEach {
            pairs.add(Pair(it[0], it[2]))
        }

        var totalPoints = 0
        pairs.forEach{pair ->
            when(pair.first) {
                // rock
                'A' -> {
                    when(pair.second) {
                        'X' -> totalPoints += 0 + 3
                        'Y' -> totalPoints += 3 + 1
                        'Z' -> totalPoints += 6 + 2
                    }
                }
                //paper
                'B' -> {
                    when(pair.second) {
                        'X' -> totalPoints += 0 + 1
                        'Y' -> totalPoints += 3 + 2
                        'Z' -> totalPoints += 6 + 3
                    }
                }
                //scissors
                'C' -> {
                    when(pair.second) {
                        'X' -> totalPoints += 0 + 2
                        'Y' -> totalPoints += 3 + 3
                        'Z' -> totalPoints += 6 + 1
                    }
                }
            }
        }
        println("Total points $totalPoints")
    }

    fun countTotalFirstPart(){
        val fileName = "src/main/resources/pairs.txt"
        val lines: List<String> = File(fileName).readLines()
        val pairs: MutableList<Pair<Char, Char>> = mutableListOf()
        lines.forEach {
            pairs.add(Pair(it[0], it[2]))
        }

        var totalPoints = 0
        pairs.forEach{pair ->
            when(pair.second) {
                // rock
                'X' -> {
                    totalPoints += 1
                    when(pair.first) {
                        'A' -> totalPoints += 3
                        'B' -> totalPoints += 0
                        'C' -> totalPoints += 6
                    }
                }
                //paper
                'Y' -> {
                    totalPoints += 2
                    when(pair.first) {
                        'A' -> totalPoints += 6
                        'B' -> totalPoints += 3
                        'C' -> totalPoints += 0
                    }
                }
                //scissors
                'Z' -> {
                    totalPoints += 3
                    when(pair.first) {
                        'A' -> totalPoints += 0
                        'B' -> totalPoints += 6
                        'C' -> totalPoints += 3
                    }
                }
            }
        }
        println("Total points $totalPoints")
    }
}