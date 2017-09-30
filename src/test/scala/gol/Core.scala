package gol

import org.scalatest.{WordSpec, Matchers}

class Core extends WordSpec with Matchers {
  "An empty Universe" should {
    val emptyUniverse: Universe = Universe.empty

    "tick" in {
      emptyUniverse.tick shouldBe an[Universe]
    }

    "stay empty" in {
      emptyUniverse.tick shouldBe emptyUniverse
    }
    "have no alive cells" in {
      emptyUniverse.howManyAliveCells shouldBe 0
    }
  }
  "A single cell universe" should {
    val listOfOneCell = List(Cell(true))
    val singleCellUniverse: Universe = Universe(listOfOneCell)

    "have one alive cell" in {
      singleCellUniverse.howManyAliveCells shouldBe 1
    }
    "not have alive cells after a tick" in {
      singleCellUniverse.tick.howManyAliveCells shouldBe 0
    }
  }
}
