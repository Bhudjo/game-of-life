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
    val position = LinearPosition(0)
    val listOfOneCell = List(Cell(isAlive = true, position))
    val singleCellUniverse: Universe = Universe(listOfOneCell)

    "have one alive cell" in {
      singleCellUniverse.howManyAliveCells shouldBe 1
    }
    "not have alive cells after a tick" in {
      singleCellUniverse.tick.howManyAliveCells shouldBe 0
    }
  }
  "A cell" should {
    "know its position" in {
      val position = LinearPosition(0)
      Cell(isAlive = true, position).position shouldBe position
    }
  }
}
