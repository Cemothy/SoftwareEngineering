package model
import model.Stone
import model.Matrix._
import scala.io.StdIn._


case class Grid(var field: Matrix[Stone]) {

    var currentPlayer = Player.white
    
    def this(size:Int) = this(new Matrix[Stone](size, Stone.empty))

    val size: Int = field.size
    
    def StoneAt(row: Int, col: Int): Stone = field.cell(row,col)
    def StoneAtBoard(row: Int, col: Int): Stone = field.cell(size-row, col-1)

    def set(row: Int, col: Int, value: Stone): Unit = {
      field = field.replaceCell(row, col, value)
    }

    // Methode zum Hinzufügen eines weißen Spielsteins
    def addWhitePiece(row: Int, col: Int): Unit = {
      set(row,col,Stone.o)
    } 
  

    // Methode zum Hinzufügen eines schwarzen Spielsteins
    def addBlackPiece(row: Int, col: Int): Unit = {
      set(row,col,Stone.x)
    }


    // Methode zum Entfernen eines Spielsteins
    def removePiece(row: Int, col: Int): Unit  = {
      set(row,col,Stone.empty)
    }

    
    //Methode für Basic Move, ohn Springen und erlaubt bis jetzt auch noch manche illegale Züge
    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Boolean = {
      print(size)
        var colMov = 0
        var geschlagen = false
        //ist das Feld innerhalb der Boundaries
        if((row < 1 || row > this.size+1) || (col < 1 || col > this.size+1)) 
            print("Field is out of bounds!")
            return false
        
        //ist das Zielfeld innerhalb der Boundaries
        if((rowDest < 1 || rowDest > this.size+1) || (colDest < 1 || colDest > this.size+1)) 
            print("Destination is out of bounds!")
            return false

        //ist an der Stelle ein ein Stein der erforderten Farbe
        if((this.StoneAtBoard(row,col).equals(Stone.empty)))
            print(StoneAtBoard(row,col))
            print("No Piece at target Field")
            return false
        if((this.currentPlayer.equals(Player.white)))
            if(!(this.StoneAtBoard(row,col).equals(Stone.o)))
                print("Not a white Piece")
                return false
        if((this.currentPlayer.equals(Player.black)))
            if(!(this.StoneAtBoard(row,col).equals(Stone.x)))
                print("Not a black Piece")
                return false
        //Wird geschlagen?
        //Weiß
        if(this.currentPlayer.equals(Player.white))
          if((rowDest - row) == 2 && (Math.abs(colDest-col) == 2)) 
            if(colDest-col > 0)
                colMov = 1
            else 
                colMov = -1 
            if(this.StoneAtBoard(row+1,(col + colMov)).equals(Stone.x))
                removePiece(size-row,col-1)
                removePiece(size-row+1,col-1+colMov)
                addWhitePiece(size-rowDest,colDest-1)

                print("geschlagen")
                geschlagen = true
                //hier muss noch Code für Folgeschläge hin

        //Schwarz
        else if(this.currentPlayer.equals(Player.black))
          if((rowDest - row) == -2 && (Math.abs(colDest-col) == 2)) 
            if(colDest-col > 0) 
                colMov = 1
            else 
                colMov = -1 
            if(this.StoneAtBoard(row + 1,(col + colMov)).equals(Stone.o))
                removePiece(size-row,col-1)
                removePiece(size-row+1,col-1+colMov)
                addWhitePiece(size-rowDest,colDest-1)

                print("geschlagen")
                geschlagen = true
                //hier muss noch Code für Folgeschläge hin
        //Schlag regel ? 
            //if(Gibts einen Schlag)
        //ist das Ziel eins schräg nebendran ?
        if(geschlagen == false)
            //weiß
            if(this.currentPlayer.equals(Player.white))
                if(!((rowDest-row) == 1 && Math.abs(colDest-col) == 1))
                    print("illegal Move!")
                    return false
                //ein Stein an der Stelle? 
                if(!(StoneAtBoard(rowDest,colDest).equals(Stone.empty)))
                    print("Field is blocked")
                //Spielzug
                removePiece(size-row,col-1)
                addWhitePiece(size-rowDest,colDest-1)
                print("moved!")

            
            //black
            if(this.currentPlayer.equals(Player.black))
                if(!((rowDest-row) == -1) && Math.abs(colDest-col) == 1)
                    print("illegal Move!")
                    return false
                //ein Stein an der Stelle
                if(!(StoneAtBoard(rowDest,colDest).equals(Stone.empty)))
                    print("Field is blocked")
                //Spielzug
                removePiece(size-row,col-1)
                addBlackPiece(size-rowDest,colDest-1)
                print("moved!")
                

        true
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
    while (!this.finished()){
      print(this.toString)
      if(this.currentPlayer.equals(Player.white)){
        print("Weiss ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        //val row = rowS.toInt
        //val col = colS.toInt
        //val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(movePiece(row, col, rowDest, colDest)) {
          this.currentPlayer = Player.black
      }
    } else if(this.currentPlayer.equals(Player.black)){
        print("Schwarz ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(movePiece(row, col, rowDest, colDest)){
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