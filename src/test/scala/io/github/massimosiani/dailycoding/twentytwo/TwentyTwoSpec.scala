package io.github.massimosiani.dailycoding.twentytwo

import io.github.massimosiani.dailycoding.BaseSpec

class TwentyTwoSpec extends BaseSpec {

  "#22 [Medium]" when {
    "is given thequickbrownfox" should {
      "return ['the', 'quick', 'brown', 'fox']" in {
        TwentyTwo.solve(Set("quick", "brown", "the", "fox"))("thequickbrownfox") shouldBe List("the", "quick", "brown", "fox")
      }
    }

    "is given bedbathandbeyond" should {
      "return ['bedbath', 'and', 'beyond']" in {
        List(List("bed", "bath", "and", "beyond"), List("bedbath", "and", "beyond")) should contain(
          TwentyTwo.solve(Set("bed", "bath", "bedbath", "and", "beyond"))("bedbathandbeyond")
        )
      }
    }

    "uses hashes" should {
      "return ['the', 'quick', 'brown', 'fox']" in {
        TwentyTwo.solveWithHashes(Set("quick", "brown", "the", "fox"))("thequickbrownfox") shouldBe List("the", "quick", "brown", "fox")
      }

      "return ['bedbath', 'and', 'beyond']" in {
        List(List("bed", "bath", "and", "beyond"), List("bedbath", "and", "beyond")) should contain(
          TwentyTwo.solveWithHashes(Set("bed", "bath", "bedbath", "and", "beyond"))("bedbathandbeyond")
        )
      }
    }
  }
}
