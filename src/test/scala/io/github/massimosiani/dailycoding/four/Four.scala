package io.github.massimosiani.dailycoding.four

import io.github.massimosiani.dailycoding.BaseSpec
import io.github.massimosiani.dailycoding.four.Main._

class Four extends BaseSpec {

  "#4 [Hard]" should {
    "pass [2]" in {
      val input = List(2)
      solve(input).value shouldBe 1
    }

    "pass [3, 4, -1, 1]" in {
      val input = List(3, 4, -1, 1)
      solve(input).value shouldBe 2
    }

    "pass [1, 2, 0]" in {
      val input = List(1, 2, 0)
      solve(input).value shouldBe 3
    }
  }
}
