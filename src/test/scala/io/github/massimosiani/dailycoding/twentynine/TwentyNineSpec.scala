package io.github.massimosiani.dailycoding.twentynine

import io.github.massimosiani.dailycoding.BaseSpec
import io.github.massimosiani.dailycoding.twentynine.TwentyNine._
import org.scalacheck.{Arbitrary, Gen, Shrink}
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class TwentyNineSpec extends AnyPropSpec with Matchers with ScalaCheckPropertyChecks {

  property("perform the round trip") {
    forAll(Gen.alphaStr)(input => (encode _ andThen decode)(input) shouldBe input)
  }
}

class TwentyNineParserSpec extends BaseSpec {

  "#29 [Easy]" should {
    "encode AAAABBBCCDAA" in {
      encode("AAAABBBCCDAA") shouldBe "4A3B2C1D2A"
    }

    "decode 4A3B2C1D2A" in {
      decode("4A3B2C1D2A") shouldBe "AAAABBBCCDAA"
    }
  }
}
