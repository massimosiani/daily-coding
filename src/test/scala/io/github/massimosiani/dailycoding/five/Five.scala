package io.github.massimosiani.dailycoding.five

import io.github.massimosiani.dailycoding.BaseSpec
import io.github.massimosiani.dailycoding.five.Main._

class Five extends BaseSpec {

  "#5 [Medium]" should {
    "car(cons(3, 4))" should {
      "return 3" in {
        car[Int, Int](cons(3, 4)) shouldBe 3
      }
    }

    "cdr(cons(3, 4))" should {
      "return 4" in {
        cdr[Int, Int](cons(3, 4)) shouldBe 4
      }
    }
  }
}
