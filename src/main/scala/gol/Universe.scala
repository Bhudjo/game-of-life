package gol

case class Universe() {
  def tick: Universe = this
}

case object Universe {
  def empty: Universe = Universe()
}
