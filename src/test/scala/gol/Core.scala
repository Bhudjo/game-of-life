package gol

import org.scalatest.{FlatSpec, Matchers}

class Core extends FlatSpec with Matchers {
  "An empty Universe" should {
    "tick" in {
      val emptyUniverse: Universe = Universe.empty
      emptyUniverse.tick shouldBe an[Universe]
    }
  }
}
