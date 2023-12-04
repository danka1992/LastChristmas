import java.io.File

class Rucksack {
    fun sumOfPrioritiesOfMisplacedItems() {
        val file = readFile()
        val pairs = splitIntoPair(file)
        val duplicateItems = mutableListOf<Char>()
        pairs.forEach {
            duplicateItems += compareItems(it)
        }
        val sum = prioritiesSum(duplicateItems)
        println("Sucet priorit je: $sum")
    }
    private fun readFile() : List<String> {
        val fileName = "src/main/resources/rucksack.txt"
        return File(fileName).readLines()
    }

    fun sumOfBadgesPriorities() {
        val file = readFile()
        val first = file.slice(IntRange(0, 99))
        val second = file.slice(IntRange(100, 199))
        val third = file.slice(IntRange(200, 299))

        val allThings = mutableListOf<Char>()

        for(i in 0..299 step 3) {
            for(it in file[i]) {
                if(file[i+1].contains(it) && file[i+2].contains(it)){
                    println("Char na $i. mieste: $it")
                    allThings.add(it)
                    break
                }
            }
        }

        println("Vsetky badges: ${prioritiesSum(allThings)}")
    }

    private fun splitIntoPair(itemsInRucksack : List<String>) : MutableList<Pair<String, String>> {
        val splitItems : MutableList<Pair<String, String>> = mutableListOf()
        itemsInRucksack.forEach{
            val itemsInOnePart = it.length / 2
            splitItems.add(
                Pair(
                    it.slice(IntRange(0, itemsInOnePart -1)),
                    it.slice(IntRange(itemsInOnePart, it.length - 1))
                    )
            )
            println("Prva cast: ${splitItems.last().first}. Druha cast: ${splitItems.last().second}")
        }
        return splitItems
    }

    private fun compareItems(splitItem: Pair<String, String>) : MutableList<Char> {
        val duplicateItems = mutableListOf<Char>()
        splitItem.first.forEach {
            if(splitItem.second.contains(it) && !duplicateItems.contains(it)) duplicateItems.add(it)
        }
        println("Duplicate items: $duplicateItems")
        return duplicateItems
    }

    private fun prioritiesSum(duplicateItems : MutableList<Char>) : Int {
        val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var finalSum = 0
        duplicateItems.forEach {
            finalSum += alphabet.indexOf(it) + 1
        }
        return finalSum
    }
}