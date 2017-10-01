package gol
//its rules could be mixed in with traits

case class Cell(isAlive: Boolean, position: LinearPosition) {
  def evolve(numberNeighboursAlive: Int): Cell = {
    if (isAlive) {
      if (numberNeighboursAlive < 2) evolveWithState(false)
      else {
        val survives = numberNeighboursAlive == 2 || numberNeighboursAlive == 3
        if (survives)
          evolveWithState(true)
        else evolveWithState(false)
      }
    } else {
      if (numberNeighboursAlive == 3) evolveWithState(true)
      else evolveWithState(false)
    }
  }

  def evolveWithState(isAlive: Boolean) = Cell(isAlive, position)

}
