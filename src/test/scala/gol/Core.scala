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
  "A planar universe (only one dimension)" can {
    "have three cells in it" should {
      val cell0 = Cell(true, LinearPosition(0))
      val cell1 = Cell(true, LinearPosition(1))
      val cell2 = Cell(true, LinearPosition(2))
      val threeCellRow: Seq[Cell] = List(cell0, cell1, cell2)
      val planarUniverse = Universe(threeCellRow)
      "know the neighbours of a cell" in {
        planarUniverse.getNeighboursOf(cell1.position) should contain(cell0,
                                                                      cell2)
      }
    }
  }
}
