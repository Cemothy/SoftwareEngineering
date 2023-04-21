import scala.compiletime.ops.boolean
import org.scalactic.Bool
import scala.io.StdIn._


class Field {

  // Größe des Spielbretts
  val size = 8

  //Spielfeld
  val board = Array.ofDim[Stone](size, size)

  // x = schwarz
  // o = weiß
  enum Stone {
    case x, o, empty
  }

  enum Player {
    case white, black
  }

  var currentPlayer = Player.white
  


  // Initialisiert das Spielbrett mit leeren Feldern
  def initBoard(): Unit = {
  for (row <- 0 until size) {
    for (col <- 0 until size) {
      board(row)(col) = Stone.empty
    }
  }
  }
  

  // Print bar
  def bar() = " " + ("+" + "-" * 3) * size + "+\n"

  // Methode zum Anzeigen des Spielbretts auf der Konsole
  def displayBoard(): Unit = {
    for (row <- 0 until size) {
      print(bar())
      print(size - row)
      for (col <- 0 until size) {
        // Überprüfen, ob sich eine Figur in diesem Feld befindet
        if (board(row)(col).equals(Stone.o)) {
          // Ausgabe des Rechtecks mit weißem Spielstein
          print("| o ")
        } else if (board(row)(col).equals(Stone.x)){
          // Ausgabe des Rechtecks mit schwarzen Spielstein
          print("| x ")
        } else {
          print("|   ")
        }
      }
      print("|\n")
    }
    print(bar())
    for(i <- 1 until size+1) print("   " + i)
    print("\n")
    
  }

  def startingBoard(): Unit = {
    initBoard()
    // oberer Spieler
    for (i <- 0 to size-1 by 2)
    {
      addBlackPiece(0,i)
    }
    for (i <- 1 to size-1 by 2) {
      addBlackPiece(1,i)
    }
    for (i <- 0 to size-1 by 2) {
      addBlackPiece(2,i)
    }

    // unterer Spieler
    for (i <- 1 to size-1 by 2) {
      addWhitePiece(size-3,i)
    }
    for (i <- 0 to size-1 by 2) {
      addWhitePiece(size-2,i)
    }
    for (i <- 1 to size-1 by 2) {
      addWhitePiece(size-1,i)
    }
  }

  // Methode zum Hinzufügen eines weißen Spielsteins
  def addWhitePiece(row: Int, col: Int): Unit = {
    board(row)(col) = Stone.o
  }

  // Methode zum Hinzufügen eines schwarzen Spielsteins
  def addBlackPiece(row: Int, col: Int): Unit = {
    board(row)(col) = Stone.x
  }

  // Methode zum Entfernen eines Spielsteins
  def removePiece(row: Int, col: Int): Unit = {
    board(row)(col) = Stone.empty
  }

  //Basic Move, Capturing not included yet!
  def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Boolean = {
    if(!board(rowDest)(colDest).equals(Stone.empty)){
      print("Illegal Move: Destination Field is occupied!\n")
      return false
    }
    if((row-rowDest).abs >1 || (col-colDest).abs > 1){
      print("Illegal Move: Destination Field is out of reach!\n")
      return false
    }
    if(board(row)(col).equals(Stone.o)){
      addWhitePiece(rowDest,colDest)
    } else if (board(row)(col).equals(Stone.x)) {
      addBlackPiece(rowDest,colDest)
    }
    removePiece(row,col)
    return true
  }

  //Checked ob es für den gegebenen Stein noch einen möglichen Zug gibt
  def possibleMove(row: Int, col: Int): Boolean = {
    return false
    if(board(row)(col).equals(Stone.x)){
      if(board(row-1)(col+1).equals(Stone.empty) || board(row-1)(col-1).equals(Stone.empty)){ //Corner Case führt zu NullPointer!!!
      return true
    } else {
      if(board(row+1)(col+1).equals(Stone.empty) || board(row+1)(col-1).equals(Stone.empty)){
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
        if(board(row)(col).equals(Stone.o) && currentPlayer.equals(Player.white)){
          if(possibleMove(row,col)) {
            result = true
          }
        } else if(board(row)(col).equals(Stone.x) && currentPlayer.equals(Player.black)) {
          if(possibleMove(row,col)) {
            result = true
          }
        }
      }
    }
    result
  }



  def startGame(): Unit = {
    while(!finished()){
      if(currentPlayer.equals(Player.white)){
        print("Weiss ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        print("junge")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        //val row = rowS.toInt
        //val col = colS.toInt
        //val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(movePiece(size-row, col-1, size-rowDest, colDest-1)) {
          displayBoard()
          currentPlayer = Player.black
        }
      }else if(currentPlayer.equals(Player.black)){
        print("Schwarz ist am Zug: \n")
        print("Welchen Stein willst du bewegen: ")
        val Array(row,col) = readLine.split(" ").map(_.toInt)
        print("Wohin: ")
        val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
        if(movePiece(size-row, col-1, size-rowDest, colDest-1)) {
          displayBoard()
          currentPlayer = Player.white
        }
      }
    } 
  }

  
}
  def main(args: Array[String]) = {

    val game = new Field
    game.startingBoard()
    game.displayBoard();
    game.startGame()
    //movePiece(5,1,4,2)
    //displayBoard()
    //movePiece(5,1,4,3)
    //displayBoard()
    //println(mesh)
    //println(startingBoard())

  }



