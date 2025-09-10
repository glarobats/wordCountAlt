```
# WordCount with Apache Spark

This project implements a **Word Count** application using **Apache Spark** in Scala.  
It counts the frequency of each word in a text file and saves the results to an output directory.

---

## Features
- Reads a text file from local filesystem or HDFS.
- Cleans text by removing punctuation and converting to lowercase.
- Splits lines into words and counts their occurrences.
- Saves the word counts to an output directory.

---

## Project Structure
```
src/
└── WordCount.scala # Main Spark application
input/
└── Shakespeare.txt # Input text file
output/ # Output directory (created after running)

```

---

## Requirements
- Scala 2.12+  
- Apache Spark 2.x or 3.x  
- sbt or any IDE supporting Scala/Spark projects  

---

## How to Run

### Using sbt
```bash
sbt package
spark-submit \
  --class WordCount \
  --master local[2] \
  target/scala-2.12/wordcount_2.12-1.0.jar
```

Directly in IntelliJ IDEA

Open the project in IntelliJ IDEA.

Open WordCount.scala.

Click the Run button to execute.

Input Example

Shakespeare.txt (partial):
```
To be, or not to be: that is the question
Whether 'tis nobler in the mind to suffer
The slings and arrows of outrageous fortune
```

Output Example
```
(to,3)
(be,2)
(or,1)
(not,1)
(that,1)
(is,1)
(the,3)
...
```
Output is saved in output/ directory as text files.

Notes

- Punctuation is removed and all words are converted to lowercase.

- You can adjust local[2] in SparkConf to change the number of cores used.

