package io.github.massimosiani.dailycoding.twentyeight

import scala.annotation.tailrec

object TwentyEight {

  def solve(k: Int, words: List[String]): List[String] = List.unfold(words) {
    case Nil => None
    case r   => eatLine(k, r, "")
  }

  @tailrec
  private def eatLine(k: Int, r: List[String], curr: String): Option[(String, List[String])] =
    if (r.isEmpty) Some((justifyLine(k, curr), r))
    else if (curr.length + 1 + r.head.length > k) Some((justifyLine(k, curr), r))
    else eatLine(k, r.tail, (curr + " " + r.head).trim)

  private def justifyLine(k: Int, line: String): String = {
    val words = line.split(" ")
    if (words.length == 1) line.padTo(k, ' ')
    else {
      val regularSpaces = (k - words.map(_.length).sum) / (words.length - 1)
      val extraSpaces = k - regularSpaces * (words.length - 1) - words.map(_.length).sum
      words.tail
        .foldLeft((words.head, extraSpaces)) { (acc, word) =>
          acc match {
            case (s, n) if n > 0 => (s ++ (" " repeat (regularSpaces + 1)) ++ word, n - 1)
            case (s, _)          => (s ++ (" " repeat regularSpaces) ++ word, 0)
          }
        }
        ._1
    }
  }
}
