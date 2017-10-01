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
      emptyUniverse.howManyAliveCellsInAllUniverse shouldBe 0
    }
  }
  "A single cell universe" should {
    val position = LinearPosition(0)
    val listOfOneCell = List(Cell(isAlive = true, position))
    val singleCellUniverse: Universe = Universe(listOfOneCell)

    "have one alive cell" in {
      singleCellUniverse.howManyAliveCellsInAllUniverse shouldBe 1
    }
    "not have alive cells after a tick" in {
      singleCellUniverse.tick.howManyAliveCellsInAllUniverse shouldBe 0
    }
  }
  "A cell" should {
    "know its position" in {
      val position = LinearPosition(0)
      Cell(isAlive = true, position).position shouldBe position
    }
  }
  "A linear universe (only one dimension)" can {
    "have three cells in it" should {
      val threeCellRow: Seq[Cell] =
        (0 to 2).map(i => Cell(isAlive = true, LinearPosition(i)))
      val planarUniverse = Universe(threeCellRow)

      "know the neighbours of a cell" in {
        val itsNeighbours = planarUniverse getNeighboursOf threeCellRow(1).position
        itsNeighbours should (contain(threeCellRow.head) and contain(
          threeCellRow(2)))
      }
      "evolve in a universe with only one cell alive" in {
        planarUniverse.tick.howManyAliveCellsInAllUniverse shouldBe 1
      }
      "should evolve in a empty universe after two ticks" in {
        planarUniverse.tick.tick.howManyAliveCellsInAllUniverse shouldBe 0
      }
    }
  }
  "A planar universe (two dimensions)" should {
    "exist" in {
      Universe.withNDimensions(2) shouldBe an[Universe]
    }
  }
}
