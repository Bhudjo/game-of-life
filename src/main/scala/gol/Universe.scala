package gol

trait Universe[A] {

  def cells: A

  def getNeighboursOf(position: Position): Set[Cell]

  def howManyAliveCellsInAllUniverse: Int

  def howManyAliveCells(cells: Set[Cell]): Int

  def tick: Universe[A]

  def countAliveNeighboursOf(cell: Cell): Int =
    howManyAliveCells(getNeighboursOf(cell.position))
}

case object Universe {
  def withNDimensions(i: Int) = {
    if (i == 1) LinearUniverse(List.empty)
    else PlanarUniverse(List(List.empty))
  }

  def empty: Universe[LinearCells] = LinearUniverse(List.empty)
}
