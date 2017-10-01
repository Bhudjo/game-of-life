package gol
//its rules could be mixed in with traits

case class Cell(state: Boolean) {
  def evolve(numberNeighboursAlive: Int): Cell = {
    if (isAlive) {
      if (numberNeighboursAlive < 2) Cell(false)
      else {
        val survives = numberNeighboursAlive == 2 || numberNeighboursAlive == 3
        if (survives)
          Cell(true)
        else Cell(false)
      }
    } else {
      if (numberNeighboursAlive == 3) Cell(true)
      else Cell(false)
    }
  }

  def isAlive = state
}
