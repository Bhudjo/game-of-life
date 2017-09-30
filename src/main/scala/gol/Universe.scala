package gol

case class Universe(cells: Seq[Cell]) {

  def howManyAliveCells = cells.count(_.isAlive)

  def tick: Universe = this
}

case object Universe {
  def empty: Universe = Universe(List.empty)
}
