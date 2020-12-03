data class PasswordData(val startRange: Int, val endRange: Int,  val policy: Char, val value: String)

object FileParser {
    fun readLines()
            = this::class.java.getResourceAsStream("exercise1-input.txt").bufferedReader().readLines()
            .map(this::parseLine)

    private fun parseLine(line: String): PasswordData {
        val columns: Array<String> = line.split(" ").toTypedArray()
        val range = columns[0]
        val rawPolicy = columns[1]
        val password = columns[2]

        val rangeValues = range.split("-").toTypedArray()
        val policy = rawPolicy.replace(":", "")

        return PasswordData(rangeValues[0].toInt(), rangeValues[1].toInt(),
                policy.toCharArray()[0],
                password
        )
    }
}

fun validPassword(passwordData: PasswordData): Boolean {
    val occurs = passwordData.value.count{ it == passwordData.policy }
    return occurs >= passwordData.startRange && occurs <= passwordData.endRange;
}


fun main() {
    val lines = FileParser.readLines()
    val occurs = lines.filter(::validPassword).count()
    println("Number of passwords: $occurs")
}