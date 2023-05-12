package model
import Stone._

case class Matrix[T](board: Vector[Vector[T]]) {

    def this(size: Int, filling: T) = this(Vector.tabulate(size,size) { (row, col) => filling})

    val size: Int = board.size

    def cell(row: Int, col: Int): T = board(row)(col)

    def fill(filling: T): Matrix[T] = copy(Vector.tabulate(size,size) {(row, col) => filling})

    def replaceCell(row: Int, col: Int, cell: T): Matrix[T] = copy(board.updated(row, board(row).updated(col,cell)))

    

        
    //Checked ob es für den gegebenen Stein noch einen möglichen Zug gibt(funktioniert noch nicht richtig)
    def possibleMove(row: Int, col: Int): Boolean = {
        return false
        if(cell(row,col).equals(Stone.empty)) return false
        if(cell(row,col).equals(Stone.x)){
            if(row == size-1) return false
            if(col == size -1) return cell(row-1,col-1).equals(Stone.empty)
            if(col == 0) return cell(row-1,col+1).equals(Stone.empty)
            if(cell(row-1,col+1).equals(Stone.empty) || cell(row-1,col-1).equals(Stone.empty)){ //Corner Case führt zu NullPointer!!!
            return true
        } else {
            if(row == 0) return false
            if(col == size -1) return cell(row+1,col-1).equals(Stone.empty)
            if(col == 0) return cell(row+1,col+1).equals(Stone.empty)
            if(cell(row+1,col+1).equals(Stone.empty) || cell(row+1,col-1).equals(Stone.empty)){
            return true
            }
        }
        }
        return false
    }
    //Ckecked ob es noch einen möglichen Zug gibt 
   
    
}
