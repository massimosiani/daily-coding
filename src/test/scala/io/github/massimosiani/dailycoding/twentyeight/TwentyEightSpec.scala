package io.github.massimosiani.dailycoding.twentyeight

import io.github.massimosiani.dailycoding.BaseSpec

class TwentyEightSpec extends BaseSpec {

  "#28 [Medium]" should {
    "justify [\"the\", \"quick\", \"brown\", \"fox\", \"jumps\", \"over\", \"the\", \"lazy\", \"dog\"] and k = 16" in {
      TwentyEight.solve(16, List("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")) should contain theSameElementsInOrderAs List(
        "the  quick brown",
        "fox  jumps  over",
        "the   lazy   dog"
      )
    }

    "justify [\"the\", \"quick\", \"brown\", \"fox\", \"jumps\", \"over\", \"the\", \"lazy\", \"dog\"] and k = 9" in {
      TwentyEight.solve(9, List("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")) should contain theSameElementsInOrderAs List(
        "the quick",
        "brown fox",
        "jumps    ",
        "over  the",
        "lazy  dog"
      )
    }
  }
}
