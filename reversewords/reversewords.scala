import scala.io.Source
import scala.util.matching.Regex

object Reversewords extends Application {
	def reverseLine(line: String): String = {
		val matcher = new Regex("""(\W*)(\w+)(\W*)""")
		val it = matcher.findAllIn(line)
		var rev = ""
		while (it.hasNext) {
			rev += it.group(1) + it.group(2).reverse + it.group(3)
			it.next
		}
		
		return rev
	}

    override def main(args: Array[String]) {
		for (line <- Source.fromFile(args(0)).getLines) {
			println(reverseLine(line))
		}
	}
}