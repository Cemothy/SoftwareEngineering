

object Field {

  enum Stone {
    case x, o, empty
  }
  

  // Größe des Spielbretts
  val size = 8

<<<<<<< HEAD
  // Seperator
  val seperator = System.getProperty("line.separator")

  // Initialisiert das Spielbrett mit leeren Feldern
  val board = Array.ofDim[String](size, size+1)
=======
  //Seperator
  val seperator: String = System.getProperty("line.separator")

  // Initialisiert das Spielbrett mit leeren Feldern
  val board: Array[Array[String]] = Array.ofDim[String](size, size)
>>>>>>> ee71c2a613613167eb90b83435dc51cf88d2337a
  for (row <- 0 until size) {
    for (col <- 0 until size) {
      board(row)(col) = "x"
    }
    board(row)(size) = "+\n"
  }

<<<<<<< HEAD
  // Print bar
  def bar() = ("+" + "-" * 3) * 8 + "+" + seperator
=======
  def bar(): String = ("+" + "-" * 3) * 8 + "+" + seperator
>>>>>>> ee71c2a613613167eb90b83435dc51cf88d2337a

  // Methode zum Anzeigen des Spielbretts auf der Konsole
  def displayBoard(): Unit = {
    for (row <- 0 until size) {
      print(bar())
      for (col <- 0 until size) {
        // Überprüfen, ob sich eine Figur in diesem Feld befindet
        if (board(row)(col).contains("o")) {
          // Ausgabe des Rechtecks mit Spielstein
          print("| o ")
        } else {
          // Ausgabe des leeren Rechtecks
          print("|   ")
        }
      }
      print("|\n")
    }
    print(bar())
  }

  def startingBoard(): Unit = {

    // oberer Spieler
    for (i <- 0 to 7 by 2)
    {
      addCircle(0,i)
    }
    for (i <- 1 to 8 by 2) {
      addCircle(1,i)
    }
    for (i <- 0 to 7 by 2) {
      addCircle(2,i)
    }

    // unterer Spieler
    for (i <- 1 to 7 by 2) {
      addCircle(5,i)
    }
    for (i <- 0 to 7 by 2) {
      addCircle(6,i)
    }
    for (i <- 1 to 7 by 2) {
      addCircle(7,i)
    }
  }

  // Methode zum Hinzufügen eines Kreises zu einem Feld
  def addCircle(row: Int, col: Int): Unit = {
    board(row)(col) = board(row)(col).replaceFirst("x", "o")
  }

  // Methode zum Entfernen eines Kreises aus einem Feld
  def removeCircle(row: Int, col: Int): Unit = {
    board(row)(col) = board(row)(col).replaceFirst("o", "x")
  }

<<<<<<< HEAD
  //Basic Move, Capturing not included yet!
  def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Unit = {
    if(board(rowDest)(colDest).contains("o")){
      print("Illegal Move: Destination Field is occupied!")
      return
    }
    if((row-rowDest).abs >1 || (col-colDest).abs > 1){
      print("Illegal Move: Destination Field is out of reach!")
      return
    }
    removeCircle(row,col)
    addCircle(rowDest,colDest)
  }

  def main(args: Array[String]) = {
=======
  def main(args: Array[String]): Unit = {
>>>>>>> ee71c2a613613167eb90b83435dc51cf88d2337a

    startingBoard()
    displayBoard();
    movePiece(5,1,4,2)
    displayBoard()
    movePiece(5,1,4,3)
    displayBoard()
    //println(mesh)
    //println(startingBoard())

  }
}



