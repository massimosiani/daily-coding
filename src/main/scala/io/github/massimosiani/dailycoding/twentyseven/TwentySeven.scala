package io.github.massimosiani.dailycoding.twentyseven

object TwentySeven {

  private val map = Map(')' -> '(', ']' -> '[', '}' -> '{')
  private val values = map.values.toSet

  def solve(string: String): Boolean =
    List
      .unfold((string, List[Char]())) {
        case (s, stack) =>
          if (s.isEmpty) None
          else {
            val c = s(0)
            if (values.contains(c)) Some((c :: stack, (s.tail, c :: stack)))
            else stack.headOption.flatMap(toBeClosed => if (map(c) == toBeClosed) Some((stack.tail, (s.tail, stack.tail))) else None)
          }
      }
      .last
      .isEmpty
}
