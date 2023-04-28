package model



case class Move(field: Grid) {

   

    //Methode für Basic Move, ohn Springen und erlaubt bis jetzt auch noch manche illegale Züge
    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Grid = {
        if(!field.StoneAt(rowDest, colDest).equals(model.Stone.empty)){
        print("Illegal Move: Destination Field is occupied!\n")
        return field
        }
        if((row-rowDest).abs >1 || (col-colDest).abs > 1){
        print("Illegal Move: Destination Field is out of reach!\n")
        return field
        }
        if(field.StoneAt(row,col).equals(model.Stone.o)){
        field.addWhitePiece(rowDest,colDest)
        } else if (field.StoneAt(row,col).equals(Stone.x)) {
        field.addBlackPiece(rowDest,colDest)
        }
        field.removePiece(row,col)
        return field
    }

    
    //Checked ob es für den gegebenen Stein noch einen möglichen Zug gibt
    def possibleMove(row: Int, col: Int): Boolean = {
        return false
        if(field.StoneAt(row,col).equals(Stone.empty)) return false
        if(field.StoneAt(row,col).equals(Stone.x)){
            if(row == field.size-1) return false
            if(col == field.size -1) return field.StoneAt(row-1,col-1).equals(Stone.empty)
            if(col == 0) return field.StoneAt(row-1,col+1).equals(Stone.empty)
            if(field.StoneAt(row-1,col+1).equals(Stone.empty) || field.StoneAt(row-1,col-1).equals(Stone.empty)){ //Corner Case führt zu NullPointer!!!
            return true
        } else {
            if(row == 0) return false
            if(col == field.size -1) return field.StoneAt(row+1,col-1).equals(Stone.empty)
            if(col == 0) return field.StoneAt(row+1,col+1).equals(Stone.empty)
            if(field.StoneAt(row+1,col+1).equals(Stone.empty) || field.StoneAt(row+1,col-1).equals(Stone.empty)){
            return true
            }
        }
        }
        return false
    }

    //Ckecked ob es noch einen möglichen Zug gibt 
    def finished(): Boolean = {
        var result = false
        for(row <- 0 until field.size){
        for(col <- 0 until field.size){
            if(field.StoneAt(row,col).equals(Stone.o) && field.currentPlayer.equals(Player.white)){
            if(possibleMove(row,col)) {
                result = true
            }
            } else if(field.StoneAt(row,col).equals(Stone.x) && field.currentPlayer.equals(Player.black)) {
            if(possibleMove(row,col)) {
                result = true
            }
            }
        }
        }
        result
    }

}