package io.github.massimosiani.dailycoding.four

import eu.timepit.refined
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Positive

object Main extends App {

  def solve(input: List[Int]): Int Refined Positive = {
    val extrema: Stats = input.filter(_ > 0).foldLeft(Stats(0, 0)) { (acc, n) =>
      val acc2 = if (n < acc.min || acc.min == 0) acc.copy(min = n) else acc
      val acc3 = if (n > acc2.max || acc2.max == 0) acc2.copy(max = n) else acc2
      acc3
    }
    val result = extrema match {
      case Stats(1, max) => max + 1
      case Stats(min, _) => min - 1
    }
    refined.refineV[Positive](result).getOrElse(refined.refineMV[Positive](1))
  }
}

final case class Stats(min: Int, max: Int)
