package gol

case class Universe() {
  def aliveCells = List.empty

  def tick: Universe = this
}

case object Universe {
  def empty: Universe = Universe()
}
