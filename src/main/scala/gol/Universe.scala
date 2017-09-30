package gol

case class Universe(cells: Seq[Cell]) {

  def howManyAliveCells = cells.count(_.isAlive)

  def countAliveNeighbours(cell: Cell): Int = 0

  def tick: Universe =
    Universe(cells map { cell =>
      cell.tick(countAliveNeighbours(cell))
    })
}

case object Universe {
  def empty: Universe = Universe(List.empty)
}
