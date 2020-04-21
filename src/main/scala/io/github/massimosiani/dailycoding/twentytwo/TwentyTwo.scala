package io.github.massimosiani.dailycoding.twentytwo

object TwentyTwo {

  def solve(dictionary: Set[String])(sentence: String): List[String] = {
    val usefulDict = dictionary.filter(_.length <= sentence.length)
    List.unfold(sentence)(findWord(usefulDict))
  }

  def findWord(dictionary: Set[String])(sentence: String): Option[(String, String)] = dictionary.collectFirst {
    case word if sentence.startsWith(word) => (word, sentence.stripPrefix(word))
  }
}
