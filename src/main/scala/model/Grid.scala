package model
import model.Stone
import model.Matrix._


case class Grid(field: Matrix[Stone]) {

    var currentPlayer = Player.white
    
    def this(size:Int) = this(new Matrix[Stone](size, Stone.empty))

    val size: Int = field.size
    
    def StoneAt(row: Int, col: Int): Stone = field.cell(row,col)

    def set(row: Int, col: Int, value: Stone): Grid = copy(field.replaceCell(row, col, value))

    // Methode zum Hinzufügen eines weißen Spielsteins
    def addWhitePiece(row: Int, col: Int): Grid = set(row,col,Stone.o)
  

    // Methode zum Hinzufügen eines schwarzen Spielsteins
    def addBlackPiece(row: Int, col: Int): Grid = set(row,col,Stone.x)


    // Methode zum Entfernen eines Spielsteins
    def removePiece(row: Int, col: Int): Grid = set(row,col,Stone.empty)

    //Methode für Basic Move, ohn Springen und erlaubt bis jetzt auch noch manche illegale Züge
    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Grid = {
        if(!StoneAt(rowDest, colDest).equals(model.Stone.empty)){
        print("Illegal Move: Destination Field is occupied!\n")
        return this
        }
        if((row-rowDest).abs >1 || (col-colDest).abs > 1){
        print("Illegal Move: Destination Field is out of reach!\n")
        return this
        }
        if(StoneAt(row,col).equals(model.Stone.o)){
        addWhitePiece(rowDest,colDest)
        } else if (StoneAt(row,col).equals(Stone.x)) {
        addBlackPiece(rowDest,colDest)
        }
        removePiece(row,col)
        return this
    }

    
    //Checked ob es für den gegebenen Stein noch einen möglichen Zug gibt
    def possibleMove(row: Int, col: Int): Boolean = {
        return false
        if(StoneAt(row,col).equals(Stone.empty)) return false
        if(StoneAt(row,col).equals(Stone.x)){
            if(row == size-1) return false
            if(col == size -1) return StoneAt(row-1,col-1).equals(Stone.empty)
            if(col == 0) return StoneAt(row-1,col+1).equals(Stone.empty)
            if(StoneAt(row-1,col+1).equals(Stone.empty) || StoneAt(row-1,col-1).equals(Stone.empty)){ //Corner Case führt zu NullPointer!!!
            return true
        } else {
            if(row == 0) return false
            if(col == size -1) return StoneAt(row+1,col-1).equals(Stone.empty)
            if(col == 0) return StoneAt(row+1,col+1).equals(Stone.empty)
            if(StoneAt(row+1,col+1).equals(Stone.empty) || StoneAt(row+1,col-1).equals(Stone.empty)){
            return true
            }
        }
        }
        return false
    }

    //Ckecked ob es noch einen möglichen Zug gibt 
    def finished(): Boolean = {
        var result = false
        for(row <- 0 until size){
        for(col <- 0 until size){
            if(StoneAt(row,col).equals(Stone.o) && currentPlayer.equals(Player.white)){
            if(possibleMove(row,col)) {
                result = true
            }
            } else if(StoneAt(row,col).equals(Stone.x) && currentPlayer.equals(Player.black)) {
            if(possibleMove(row,col)) {
                result = true
            }
            }
        }
        }
        result
    }

   


    
    // Print bar
     def bar() = " " + ("+" + "-" * 3) * size + "+\n"

    //Print grid, but with var instead of val
    override def toString() = {
    var box = ""
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
        }
        box
    }   


}