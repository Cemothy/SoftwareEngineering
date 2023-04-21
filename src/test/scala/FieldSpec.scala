import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._









class FieldSpec extends AnyWordSpec {

  val field = new Field


  "A Field" should {
    "have a size of 8x8" in {
      field.size == 8
    }

    "init a empty Field by filling the Array with empty Stones" in {
      field.initBoard()
      var rowsProcessed = 0
      var colsProcessed = 0
      for (row <- 0 until field.size) {
        rowsProcessed += 1
        for (col <- 0 until field.size) {
          colsProcessed += 1
          field.board(row)(col) should be (field.Stone.empty)
        }
      }
      field.size should be (8)
      rowsProcessed should be (8) 
      colsProcessed should be (64)
    }
    
    "init an starting Board by filling the Board with x Stone and o Stones" in {
      field.startingBoard()
      for (i <- 0 to field.size-1 by 2)
      {
      field.board(0)(i) should be (field.Stone.x)
      }
      for (i <- 1 to field.size-1 by 2) {
      field.board(1)(i) should be (field.Stone.x)
      }
      for (i <- 0 to field.size-1 by 2) {
      field.board(2)(i) should be (field.Stone.x)
      }
      for (i <- 1 to field.size-1 by 2) {
      field.board(field.size-3)(i) should be (field.Stone.o)
      }
      for (i <- 0 to field.size-1 by 2) {
      field.board(field.size-2)(i) should be (field.Stone.o)
      }
      for (i <- 1 to field.size-1 by 2) {
      field.board(field.size-1)(i) should be (field.Stone.o)
      }
    }

    "have a bar as String of form '+---+---+---+---+---+---+---+---+'" in {
      val output = field.bar()
      val expected = " +---+---+---+---+---+---+---+---+\n"
      output should equal(expected)
    }

    
    "Display the Board correctly " in {
      field.startingBoard()
      val stream = new java.io.ByteArrayOutputStream
      Console.withOut(stream) {
      val output = field.displayBoard()
      }
      print(stream)
      
      val expected =  " +---+---+---+---+---+---+---+---+\n"+
                      "8| x |   | x |   | x |   | x |   |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "7|   | x |   | x |   | x |   | x |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "6| x |   | x |   | x |   | x |   |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "5|   |   |   |   |   |   |   |   |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "4|   |   |   |   |   |   |   |   |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "3|   | o |   | o |   | o |   | o |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "2| o |   | o |   | o |   | o |   |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "1|   | o |   | o |   | o |   | o |\n"+
                      " +---+---+---+---+---+---+---+---+\n"+
                      "   1   2   3   4   5   6   7   8\n"
      print(expected)
      stream should equal(expected)
    }
    

    "replace the Stone at Postion (row,col) with Stone.o when addWhitePiece(row,col) is called" in {
      field.board(0)(0) = field.Stone.empty
      field.addWhitePiece(0,0)
      field.board(0)(0) should be(field.Stone.o)
    }

    "replace the Stone at Postion (row,col) with Stone.o when addBlackPiece(row,col) is called" in {
      field.board(0)(0) = field.Stone.empty
      field.addBlackPiece(0,0)
      field.board(0)(0) should be (field.Stone.x)
    }

    "replace the Stone at Postion (row,col) with Stone.empty when remove(row,col) is called" in {
      field.board(0)(0) = field.Stone.x
      field.removePiece(0,0)
      field.board(0)(0) should be (field.Stone.empty)
    }

    "possible Move should return false (not yet finished)" in {
      field.possibleMove(0,0) should be (false)
    }

    "always return true for finshed() (not yet finished)" in {
      field.finished() should be(false)
    }

    "return false and an error Massage for an illegal Move" in {
      field.initBoard()
      field.board(0)(0) = field.Stone.x
      field.currentPlayer = field.Player.black
      field.movePiece(0,0,2,2) == false 
      field.board(1)(1) = field.Stone.x 
      field.movePiece(0,0,1,1) == false
      field.currentPlayer = field.Player.white 
      field.movePiece(0,0,1,1)
    }
    
    "return true and replace the Stone" in {
      field.initBoard()
      field.board(0)(0) = field.Stone.x
      field.currentPlayer = field.Player.black
      field.movePiece(0,0,1,1)
      field.board(0)(0) should be (field.Stone.empty)
      field.board(1)(1) should be (field.Stone.x)

      field.initBoard()
      field.board(0)(0) = field.Stone.o
      field.currentPlayer = field.Player.white
      field.movePiece(0,0,1,1)
      field.board(0)(0) should be (field.Stone.empty)
      field.board(1)(1) should be (field.Stone.o)
    }
    "start an Loop in which both Player can choose which Stone to play" in {
      val stream = new java.io.ByteArrayOutputStream
      Console.withOut(stream) {
      val output = field.startGame()
      output should equal("Weiss ist am Zug: \n")
      }
      
      
    }




    

/*
    "initialize the board with empty fields" in {
      val emptyBoard = Array.ofDim[String](Field.size, Field.size+1)
      for (row <- 0 until Field.size) {
        for (col <- 0 until Field.size) {
          emptyBoard(row)(col) = "x"
        }
        emptyBoard(row)(Field.size) = "+\n"
      }
      Field.board should be (emptyBoard)
    }

    "create a starting board" in {
      Field.startingBoard()
      Field.board(0)(0) should be("o")
      Field.board(0)(2) should be("o")
      Field.board(1)(1) should be("o")
      Field.board(1)(3) should be("o")
      Field.board(2)(0) should be("o")
      Field.board(2)(2) should be("o")
      Field.board(5)(1) should be("o")
      Field.board(6)(0) should be("o")
      Field.board(7)(1) should be("o")
    }

    "add a circle to a field" in {
      Field.addCircle(0, 0)
      Field.board(0)(0) should be("o")
    }

    "remove a circle from a field" in {
      Field.removeCircle(0, 0)
      Field.board(0)(0) should be("x")
    }
*/  
  }
  

}