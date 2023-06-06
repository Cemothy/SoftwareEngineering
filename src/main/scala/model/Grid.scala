package model
import model.Stone
import model.Matrix._
import model.Move
import scala.io.StdIn._


case class Grid(var field: Matrix[Stone]) {

    var currentPlayer = Player.white
    
    def this(size:Int) = this(new Matrix[Stone](size, Stone.empty))

    val size: Int = field.size
    
    //Returns the Stone at Pos(row,col) with Matrix Positions
    def StoneAt(row: Int, col: Int): Stone = field.cell(row,col)

    //Returns the Stone at Pos(row,col) with Real Position
    def StoneAtBoard(row: Int, col: Int): Stone = field.cell(size-row, col-1)

    //Sets (Matrix Parameters)
    def set(row: Int, col: Int, value: Stone): Unit = {
      field = field.replaceCell(row, col, value)
    }

    // Methode zum Hinzufügen eines weißen Spielsteins (Matrix)
    def addWhitePiece(row: Int, col: Int): Unit = {
      set(row,col,Stone.o)
    } 
    
    // Methode zum Hinzufügen eines weißen Spielsteins (Real Board)
    def addWhitePieceBoard(row: Int, col: Int): Unit = {
        addWhitePiece(size-row,col-1)
    }

    // Methode zum Hinzufügen eines schwarzen Spielsteins (Matrix)
    def addBlackPiece(row: Int, col: Int): Unit = {
      set(row,col,Stone.x)
    }

    // Methode zum Hinzufügen eines schwarzen Spielsteins (Real Board)
    def addBlackPieceBoard(row: Int, col: Int): Unit = {
        addBlackPiece(size-row,col-1)
    }


    // Methode zum Entfernen eines Spielsteins (Matrix)
    def removePiece(row: Int, col: Int): Unit  = {
      set(row,col,Stone.empty)
    }

    // Methode zum Entfernen eines Spielsteins (Real Board)
    def removePieceBoard(row: Int, col: Int): Unit = {
        removePiece(size-row,col-1)
    }

    def moveWhitePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Boolean = {
        val number = 1
        Move.movePiece(this, row, col, rowDest, colDest, Stone.o, number)
    }
    def moveBlackPiece(row: Int, col: Int, rowDest: Int, colDest: Int): Boolean = {
        val number = -1
        Move.movePiece(this, row, col, rowDest, colDest, Stone.x, number)
    } 

    
    def finished(): Boolean = {
        var result = false
        for(row <- 0 until size){
        for(col <- 0 until size){
            if(StoneAt(row,col).equals(Stone.o) && this.currentPlayer.equals(Player.white)){
            if(field.possibleMove(row,col)) {
                result = true
            }
            } else if(StoneAt(row,col).equals(Stone.x) && this.currentPlayer.equals(Player.black)) {
            if(field.possibleMove(row,col)) {
                result = true
            }
            }
        }
        }
        result
    }

    
    def start(): Unit = {
    var grid : Grid = null
    while (!this.finished()){
      print(this.toString)
      if(this.currentPlayer.equals(Player.white)){
        print("Weiss ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(moveWhitePiece(row,col,rowDest,colDest)){
            this.currentPlayer = Player.black
        }
    } else if(this.currentPlayer.equals(Player.black)){
        print("Schwarz ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(moveBlackPiece(row,col,rowDest,colDest)){
            this.currentPlayer = Player.white
        }
      }
  }
}

   


    
    // Print bar
     def bar() = " " + ("+" + "-" * 3) * size + "+\n"

    //Print grid, but with var instead of val
    override def toString() = {
    var box = "\n"
        for (row <- 0 until size) {
            box = box + (bar() + (size-row))
            for(col <- 0 until size) {
                if (StoneAt(row, col).equals(model.Stone.o)) {
                // Ausgabe des Rechtecks mit weißem Spielstein
                box = box + ("| o ")
                } else if (StoneAt(row,col).equals(model.Stone.x)){
                // Ausgabe des Rechtecks mit schwarzen Spielstein
                box = box + ("| x ")
                } else {
                box = box + ("|   ")
                }
            }
            box = box + ("|\n")
        }
        box = box + bar() 
        for (i <- 1 until (size+1))
            box = box + ("   " + i.toString)
        box = box + "\n"
        box
    }   


}