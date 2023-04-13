enum Stone:
  case o, Empty

case class Mesh(rows: Vector[Vector[Stone]]):
  def this(size: Int, filling: Stone) = this(Vector.tabulate(size, size) { (row, col) => filling })

  val size: Int = rows.size

  def cell(row: Int, col: Int) = rows(row)(col)

  def fill(filling: Stone): Mesh = copy(Vector.tabulate(3, 3) { (row, col) => filling })

  def replaceCell(row: Int, col: Int, cell: Stone) = copy(rows.updated(row, rows(row).updated(col, cell)))

val matrix = new Mesh(2, Stone.o)


def main (args: Array[String]) = {



}