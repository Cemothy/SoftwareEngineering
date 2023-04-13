case class Cell(x:Int, y:Int)

val cell1 = Cell(8,8)
cell1.x
cell2.x

case class Field(cells: Array[Cell])

val field1 = Field(Array.ofDim[Cell](1))
field1.cells(0)=cell1
field1.cells(0).x
field1.cells(0).y

enum Stone:
  case o, Empty

case class Mesh(rows: Vector[Vector[Stone]]):
  def cell(row: Int, col: Int) = rows(row)(col)

  def fill(filling: Stone): Mesh = copy(Vector.tabulate(3, 3) { (row, col) => filling })

  def replaceCell(row: Int, col: Int, cell: Stone) = copy(rows.updated(row, rows(row).updated(col, cell)))

val m = Mesh(Vector(Vector(Stone.o, Stone.o, Stone.o), Vector(), Vector()))
m.cell(0, 1)
val m2 = m.fill(Stone.Empty)



