package gol

case class LinearUniverse(cells: LinearCells) extends Universe[LinearCells] {
  def getNeighboursOf(position: LinearPosition): Set[Cell] =
    cells
      .filter(c =>
        c.position.i == position.i + 1 || c.position.i == position.i - 1)
      .toSet

  def tick: LinearUniverse = {
    val futureCells: LinearCells = cells map { thisCell =>
      thisCell.evolve(countAliveNeighboursOf(thisCell))
    }
    LinearUniverse(futureCells)
  }

  override def getNeighboursOf(position: Position): Set[Cell] = position match {
    case l: LinearPosition => getNeighboursOf(l)
    case _                 => Set.empty
  }

  override def howManyAliveCellsInAllUniverse: Int =
    howManyAliveCells(cells.toSet)

  override def howManyAliveCells(cells: Set[Cell]): Int = cells.count(_.isAlive)
}
