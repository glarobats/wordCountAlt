import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf, SparkContext}
object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    // create spark context
    val inputFile = "input/Shakespeare.txt"
    val outputDir = "output"
    var txtFile = sc.textFile(inputFile)

    // Αφαίρεση σημείων στίξης και μετατροπή χαρακτήρων σε πεζούς
    txtFile = txtFile.map(line => line.replaceAll("[^a-zA-Z\\s]", "").toLowerCase())

    txtFile.flatMap(line => line.split(" ")) // split each line based on spaces
      .map(word => (word,1)) // map each word into a word,1 pair
      .reduceByKey(_+_) // reduce
      .saveAsTextFile(outputDir) // save the output
    sc.stop()
  }
}