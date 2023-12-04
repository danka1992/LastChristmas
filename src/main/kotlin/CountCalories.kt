import java.io.File

class CountCalories {
    fun countCaloriesForEachElf(): Int {
        val fileName = "src/main/resources/data.txt"
        val lines: List<String> = File(fileName).readLines()
        var index = 0
        var sumOfCalories = 0
        val listOfSums: MutableList<Int> = mutableListOf()
        lines.forEach {
            if (it.isNotBlank()) {
                sumOfCalories += it.toInt()
            } else {
                listOfSums.add(index, sumOfCalories)
                println(listOfSums[index])
                sumOfCalories = 0
                index += 1
            }
        }
        listOfSums.sort()
        val total = listOfSums[listOfSums.lastIndex] + listOfSums[listOfSums.lastIndex-1] + listOfSums[listOfSums.lastIndex-2]
        return total
    }
}