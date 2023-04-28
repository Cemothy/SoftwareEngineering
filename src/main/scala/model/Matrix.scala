package model
import Stone._

case class Matrix[T](board: Vector[Vector[T]]) {

    def this(size: Int, filling: T) = this(Vector.tabulate(size,size) { (row, col) => filling})

    val size: Int = board.size

    def cell(row: Int, col: Int): T = board(row)(col)

    def fill(filling: T): Matrix[T] = copy(Vector.tabulate(size,size) {(row, col) => filling})

    def replaceCell(row: Int, col: Int, cell: T): Matrix[T] = copy(board.updated(row, board(row).updated(col,cell)))


}
