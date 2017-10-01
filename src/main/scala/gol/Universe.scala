package gol

case class Universe(cells: Seq[Cell]) {
  def getNeighboursOf(position: LinearPosition): Set[Cell] = Set.empty

  def howManyAliveCells = cells.count(_.isAlive)

  def countAliveNeighboursOf(cell: Cell): Int = 0

  def tick: Universe = {
    val futureCells: Seq[Cell] = cells map { thisCell =>
      thisCell.evolve(countAliveNeighboursOf(thisCell))
    }
    Universe(futureCells)
  }
}

case object Universe {
  def empty: Universe = Universe(List.empty)
}
