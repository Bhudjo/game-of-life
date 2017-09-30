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
      emptyUniverse.aliveCells shouldBe List.empty
    }
  }
  "A single cell universe" should {
    val listOfOneCell = List(Cell())
    val singleCellUniverse: Universe = Universe(listOfOneCell)

    "have one alive cell" in {
      singleCellUniverse.aliveCells.filter(_.isAlive).size shouldBe 1
    }
  }
}
