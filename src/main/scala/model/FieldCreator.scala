package model
import Stone._ 
import Matrix._

class FieldCreator(size:Int) {

  val field = new Grid(size)

  
  
        
  def startingBoard(): Grid = {
    // oberer Spieler
    for (i <- 0 to size-1 by 2)
    {
      field.addBlackPiece(0,i)
    }
    for (i <- 1 to size-1 by 2) {
      field.addBlackPiece(1,i)
    }
    for (i <- 0 to size-1 by 2) {
      field.addBlackPiece(2,i)
    }

    // unterer Spieler
    for (i <- 1 to size-1 by 2) {
      field.addWhitePiece(size-3,i)
    }
    for (i <- 0 to size-1 by 2) {
      field.addWhitePiece(size-2,i)
    }
    for (i <- 1 to size-1 by 2) {
      field.addWhitePiece(size-1,i)
    }
    field
  }
}
