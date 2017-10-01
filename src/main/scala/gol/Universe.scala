package gol

trait Universe {

  def cells: Seq[Cell]

  def getNeighboursOf(position: LinearPosition): Set[Cell]

  def howManyAliveCellsInAllUniverse: Int = howManyAliveCells(cells)

  def howManyAliveCells(cells: Seq[Cell]): Int = cells.count(_.isAlive)

  def tick: LinearUniverse = {
    val futureCells: Seq[Cell] = cells map { thisCell =>
      thisCell.evolve(countAliveNeighboursOf(thisCell))
    }
    LinearUniverse(futureCells)
  }

  def countAliveNeighboursOf(cell: Cell): Int =
    howManyAliveCells(getNeighboursOf(cell.position).toSeq)
}

case object Universe {
  def withNDimensions(i: Int): Universe = ???

  def empty: Universe = LinearUniverse(List.empty)
}
