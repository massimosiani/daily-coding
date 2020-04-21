package io.github.massimosiani.dailycoding.twentyseven

import io.github.massimosiani.dailycoding.BaseSpec

class TwentySevenSpec extends BaseSpec {

  "#27 [Easy]" when {
    "parses ([])[]({})" should {
      "return true" in {
        TwentySeven.solve("([])[]({})") shouldBe true
      }
    }

    "parses ([)]" should {
      "return false" in {
        TwentySeven.solve("([)]") shouldBe false
      }
    }

    "parses ((()" should {
      "return false" in {
        TwentySeven.solve("((()") shouldBe false
      }
    }
  }
}
