package gol

trait Position
case class LinearPosition(i: Int) extends Position
case class PlanarPosition(x: Int, y: Int) extends Position
