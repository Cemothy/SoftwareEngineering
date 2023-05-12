package model



case class Move(var grid: Grid) {


    /*
    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Grid = {
        var colMov = 0
        var geschlagen = false
        //ist das Feld innerhalb der Boundaries
        if((row < 1 || row > grid.size+1) || (col < 1 || col > grid.size+1)) 
            print("Field is out of bounds!")
            return grid
        
        //ist das Zielfeld innerhalb der Boundaries
        if((rowDest < 1 || rowDest > grid.size+1) || (colDest < 1 || colDest > grid.size+1)) 
            print("Destination is out of bounds!")
            return grid

        //ist an der Stelle ein ein Stein der erforderten Farbe
        if((grid.StoneAt(row,col).equals(Stone.empty)))
            print("No Piece at target Field")
        if((grid.currentPlayer.equals(Player.white)))
            if(!(grid.StoneAt(row,col).equals(Stone.o)))
                print("Not a white Piece")
        if((grid.currentPlayer.equals(Player.black)))
            if(!(grid.StoneAt(row,col).equals(Stone.x)))
                print("Not a black Piece")

        //Wird geschlagen?
        //Weiß
        if(grid.currentPlayer.equals(Player.white))
        if((rowDest - row) == 2 && ((colDest-col) == Math.abs(2))) 
            if(colDest-col > 0)
                colMov = 1
            else 
                colMov = -1 
            if(grid.StoneAt(row+1,(col + colMov)).equals(Stone.x))
                print("geschlagen")
                geschlagen = true
                //hier muss noch Code für Folgeschläge hin

        //Schwarz
        else if(grid.currentPlayer.equals(Player.black))
        if((rowDest - row) == -2 && ((colDest-col) == Math.abs(2))) 
            if(colDest-col > 0) 
                colMov = 1
            else 
                colMov = -1 
            if(grid.StoneAt(row+1,(col + colMov)).equals(Stone.o))
                print("geschlagen")
                geschlagen = true
                //hier muss noch Code für Folgeschläge hin
        //Schlag regel ? 
            //if(Gibts einen Schlag)
        //ist das Ziel eins schräg nebendran ?
        if(geschlagen == false)
            //weiß
            if(grid.currentPlayer.equals(Player.white))
                if(!((rowDest-row) == 1 && (colDest-col) == Math.abs(1)))
                    print("illegal Move!")
                    return grid
                //ein Stein an der Stelle? 
                if(!(StoneAt(rowDest,colDest).equals(Stone.empty)))
                    print("Field is blocked")
                //Spielzug
                grid.removePiece(row,col)
                grid.addWhitePiece(rowDest,colDest)

            
            //black
            if(grid.currentPlayer.equals(Player.black))
                if(!((rowDest-row) == -1) && (colDest-col) == Math.abs(1))
                    print("illegal Move!")
                    return grid
                //ein Stein an der Stelle
                if(!(StoneAt(rowDest,colDest).equals(Stone.empty)))
                    print("Field is blocked")
                //Spielzug
                grid.removePiece
                grid.addBlackPiece


        grid
    }
    */
    /*
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
        field = field.addWhitePiece(rowDest,colDest)
        } else if (field.StoneAt(row,col).equals(Stone.x)) {
        field = field.addBlackPiece(rowDest,colDest)
        }
        field = field.removePiece(row,col)
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
    */

}