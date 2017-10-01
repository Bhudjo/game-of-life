package gol

case class PlanarUniverse(cells: PlanarCells) extends Universe[PlanarCells] {
  override def getNeighboursOf(position: Position): Set[Cell] = ???

  override def howManyAliveCellsInAllUniverse: Int = ???

  override def howManyAliveCells(cells: Set[Cell]): Int = ???

  override def tick: Universe[PlanarCells] = ???
}
