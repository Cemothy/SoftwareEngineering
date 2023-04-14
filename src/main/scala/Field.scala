

object Field {
  // Größe des Spielbretts
  val size = 8

  //Seperator
  val seperator = System.getProperty("line.separator")

  // Initialisiert das Spielbrett mit leeren Feldern
  val board = Array.ofDim[String](size, size)
  for (row <- 0 until size) {
    for (col <- 0 until size) {
      board(row)(col) = "okay"
    }
    board(row)(size-1) = "+\n"
  }

  def bar() = ("+" + "-" * 3) * 8 + "+" + seperator

  // Methode zum Anzeigen des Spielbretts auf der Konsole
  def displayBoard(): Unit = {
    for (row <- 0 until size) {
      // Ausgabe der Zeilennummer
      print(bar())
      for (col <- 0 until size) {
        // Überprüfen, ob sich ein Kreis in diesem Feld befindet
        if (board(row)(col).contains("o")) {
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
      board(0)(i) = board(0)(i).replaceFirst("x", "o")
    }
    for (i <- 1 to 8 by 2) {
      board(1)(i) = board(1)(i).replaceFirst("x", "o")
    }
    for (i <- 0 to 7 by 2) {
      board(2)(i) = board(2)(i).replaceFirst("x", "o")
    }

    // unterer Spieler
    for (i <- 1 to 7 by 2) {
      board(5)(i) = board(1)(i).replaceFirst("x", "o")
    }
    for (i <- 0 to 7 by 2) {
      board(6)(i) = board(0)(i).replaceFirst("x", "o")
    }
    for (i <- 1 to 7 by 2) {
      board(7)(i) = board(7)(i).replaceFirst("x", "o")
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

  def main(args: Array[String]) = {

    startingBoard()
    displayBoard();
    //println(mesh)
    //println(startingBoard())

  }
}



