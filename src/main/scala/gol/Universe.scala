package gol

case class Universe(aliveCells: Seq[Cell]) {
  def tick: Universe = this
}

case object Universe {
  def empty: Universe = Universe(List.empty)
}
