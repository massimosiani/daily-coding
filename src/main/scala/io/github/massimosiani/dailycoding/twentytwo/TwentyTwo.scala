package io.github.massimosiani.dailycoding.twentytwo

object TwentyTwo {

  def solve(dictionary: Set[String])(sentence: String): List[String] = {
    val usefulDict = dictionary.filter(_.length <= sentence.length)
    List.unfold(sentence)(findWord(usefulDict))
  }

  def findWord(dictionary: Set[String])(sentence: String): Option[(String, String)] = dictionary.collectFirst {
    case word if sentence.startsWith(word) => (word, sentence.stripPrefix(word))
  }

  def solveWithHashes(dictionary: Set[String])(sentence: String): List[String] = {
    val usefulDict = (l: Int) => dictionary.filter(_.length <= l).map(w => (w, w.length, w.hashCode))
    List.unfold(sentence)(remaining => findWordWithHashes(usefulDict(remaining.length))(remaining))
  }

  def findWordWithHashes(dictionary: Set[(String, Int, Int)])(sentence: String): Option[(String, String)] = dictionary.collectFirst {
    case (word, size, hash) if sentence.substring(0, size).hashCode == hash => (word, sentence.stripPrefix(word))
  }
}
