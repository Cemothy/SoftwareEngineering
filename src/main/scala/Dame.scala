object dame {

    val witdth = 3
    val cellNum = 8
    val seperator = System.getProperty("line.separator")

    def bar(cellWitdth: Int = witdth, cellNum:Int = cellNum) = ("+" + "-" * cellWitdth) * cellNum + "+" + seperator
    def row(cellNum:Int = cellNum) = ("|   ") * cellNum + "|" + seperator
    def rowWithPiecesOne(cellNum:Int = cellNum) = ("| o |   ") * (cellNum/2) + "|" + seperator
    def rowWithPiecesTwo(cellNum:Int = cellNum) = ("|   | o ") * (cellNum/2) + "|" + seperator
    def startingBoard() = bar() + rowWithPiecesOne() + bar() + rowWithPiecesTwo() + bar() + rowWithPiecesOne()
      + (bar() + row()) * 2 + bar() + rowWithPiecesTwo() + bar() + rowWithPiecesOne() + bar() + rowWithPiecesTwo() + bar()


    val mesh = (bar() + row()) * 8 + bar()
    val test = (row()) * 3



    def main(args: Array[String]) = {

        //println(mesh)
        //println(startingBoard())

    }
}

