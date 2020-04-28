package io.github.massimosiani.dailycoding.twentynine

object TwentyNine {

  def encode(input: String): String = {
    val state = input.foldLeft(Encoding.empty) { (acc, c) =>
      if (acc.last.contains(c)) acc.copy(times = acc.times + 1)
      else if (acc.last.isDefined) acc.copy(s = acc.s + acc.times + acc.last.get, last = Some(c), times = 1)
      else acc.copy(last = Some(c), times = 1)
    }
    state.s + (if (state.times > 0) s"${state.times}${state.last.get}" else "")
  }

  def decode(input: String): String =
    List
      .unfold(input) { r =>
        if (r.isEmpty) None
        else Some((r.charAt(1).toString * Integer.valueOf(r.charAt(0).toString), r.substring(2)))
      }
      .mkString

  case class Encoding(s: String, last: Option[Char], times: Int)
  object Encoding {
    def empty: Encoding = Encoding("", None, 0)
  }
}
