package model
import Stone._ 
import Matrix._

class FieldCreator(var grid:Grid) {
  def this(size:Int) = this(new Grid(size))

  
  
        
  def startingBoard(): Grid = {
    // oberer Spieler
    for (i <- 0 to grid.size-1 by 2)
    {
      grid.addBlackPiece(0,i)
     
    }
    for (i <- 1 to grid.size-1 by 2) {
      grid.addBlackPiece(1,i)
    }
    for (i <- 0 to grid.size-1 by 2) {
      grid.addBlackPiece(2,i)
    }

    // unterer Spieler
    for (i <- 1 to grid.size-1 by 2) {
      grid.addWhitePiece(grid.size-3,i)
    }
    for (i <- 0 to grid.size-1 by 2) {
      grid.addWhitePiece(grid.size-2,i)
    }
    for (i <- 1 to grid.size-1 by 2) {
      grid.addWhitePiece(grid.size-1,i)
    }
    grid
  }
}
