package gol

case class LinearUniverse(cells: Seq[Cell]) extends Universe {
  def getNeighboursOf(position: LinearPosition): Set[Cell] =
    cells
      .filter(c =>
        c.position.i == position.i + 1 || c.position.i == position.i - 1)
      .toSet

}
