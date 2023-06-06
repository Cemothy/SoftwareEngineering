import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import model.{Grid, Stone, Matrix, Player}

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid" when {

    "created with size 8" should {
      val grid = new Grid(8)

      "have size 8" in {
        grid.size shouldEqual 8
      }

      "have an empty field" in {
        for (i <- 0 to grid.size-1; j <- 0 to grid.size-1) {
          grid.StoneAt(i, j) shouldEqual Stone.empty
        }
      }

      "return the right Stone" in {
        grid.addWhitePiece(0,0)
        grid addBlackPiece(0,1)
        grid.StoneAt(0,0) shouldEqual Stone.o
        grid.StoneAt(0,1) shouldEqual Stone.x
        grid.StoneAt(0,2) shouldEqual Stone.empty
      }

      "return the right Stone (Board Parameters)"in {
        grid.addWhitePieceBoard(1,1)
        grid.addBlackPieceBoard(1,2)
        grid.StoneAtBoard(1,1) shouldEqual Stone.o
        grid.StoneAtBoard(1,2) shouldEqual Stone.x
        grid.StoneAtBoard(1,3) shouldEqual Stone.empty
      }

      "set a Stone correctly" in {
        grid.set(0,0,Stone.x) 
        grid.StoneAtBoard(0,0) shouldEqual Stone.x
        grid.set(0,0,Stone.o) 
        grid.StoneAtBoard shouldEqual Stone.o
      }

      "allow adding white pieces" in {
        grid.addWhitePiece(1,1)
        grid.StoneAt(1,1) shouldEqual Stone.o
      }

      "allow adding white pieces using board parameters" in {
        grid.addWhitePieceBoard(1,1)
        grid.StoneAtBoard(1,1) shouldEqual Stone.o
      }

      "allow adding black pieces" in {
        grid.addBlackPiece(1,1)
        grid.StoneAt(1,1) shouldEqual Stone.x
      }

      "allow adding black pieces using board parameters" in {
        grid.addBlackPieceBoard(1,1)
        grid.StoneAt(1,1) shouldEqual Stone.x
      }

      "allow removing pieces" in {
        grid.addBlackPiece(1,1)
        grid.removePiece(1,1)
        grid.StoneAt(1,1) shouldEqual Stone.empty
      }

      "allow removing pieces using board parameters" in {
        grid.addBlackPieceBoard(1,1)
        grid.removePieceBoard(1,1)
        grid.StoneAtBoard(1,1) shouldEqual Stone.empty
      }

      "allow moving pieces to the rigth for white" in {
        grid.addWhitePiece(1,1)
        grid.moveWhitePiece(1,1,2,2)
        grid.StoneAtBoard(1,1) shouldEqual Stone.empty
        grid.StoneAtBoard(2,2) shouldEqual Stone.o
      }

      "allow moving pieces to the left for white" in {
        grid.addWhitePieceBoard(1,4)
        grid.moveWhitePiece(1,4,2,3)
        grid.StoneAtBoard(1,4) shouldEqual Stone.empty
        grid.StoneAtBoard(2,3) shouldEqual Stone.o
      }

      "allow capturing a piece for white (right)" in {
        grid.addWhitePieceBoard(2,2)
        grid.addWhitePieceBoard(3,3)
        grid.moveWhitePiece(2,2,4,4)
        grid.StoneAtBoard(2,2) shouldEqual Stone.empty
        grid.StoneAtBoard(3,3) shouldEqual Stone.empty
        grid.StoneAtBoard(4,4) shouldEqual Stone.o
      }

      "allow capturing a piece for white (left)" in {
        grid.addWhitePieceBoard(3,3)
        grid.addWhitePieceBoard(4,2)
        grid.moveWhitePiece(3,3,5,1)
        grid.StoneAtBoard(3,3) shouldEqual Stone.empty
        grid.StoneAtBoard(4,2) shouldEqual Stone.empty
        grid.StoneAtBoard(5,1) shouldEqual Stone.o
      }


      /*
      "allow moving pieces for black" in {
        grid.addBlackPiece(grid.size-5, 4)
        grid.removePiece(grid.size-4,3)
        grid.currentPlayer = Player.black
        grid.movePiece(5, 5, 4, 4) shouldEqual true
        grid.StoneAtBoard(4,4) shouldEqual Stone.x
      }

      "not allow to move a field with no piece" in {
        //no Piece
        grid.addWhitePiece(grid.size-5,4)
        grid.removePiece(grid.size-4,3)
        grid.movePiece(5, 5, 4, 4) shouldEqual false
      }

      "not allow to move a piece more then one field if its not capturing" in {
        //illegal Move
        grid.addWhitePiece(grid.size-5,4)
        grid.removePiece(grid.size-4,3)
        grid.movePiece(5, 5, 4, 4) shouldEqual false
      }

      "not allow to move a piece onto a field thats already occupied" in {
        //Already Occupied
        grid.addWhitePiece(grid.size-5,4)
        grid.addWhitePiece(grid.size-6,5)
        grid.movePiece(5, 5, 6, 6) shouldEqual false
      } 

      "not allow to move to a field thats out of bounds" in {
        grid.movePiece(8,8,9,9) shouldEqual false

      }

      "not allow to target a field thats out of bound" in {
        grid.movePiece(0,0,1,1) shouldEqual false
      }

      "not allow to move the opposite piece" in {
        grid.currentPlayer = Player.white
        grid.addBlackPiece(1,1)
        grid.movePiece(1,1,2,2) shouldEqual false
      }

      "allow to capture for white(right move)" in {
        grid.currentPlayer = Player.white
        grid.addWhitePieceBoard(1,1)
        grid.addBlackPieceBoard(2,2)
        grid.movePiece(1,1,3,3) shouldEqual true
        grid.StoneAtBoard(1,1) shouldEqual Stone.empty
        grid.StoneAtBoard(2,2) shouldEqual Stone.empty
        grid.StoneAtBoard(3,3) shouldEqual Stone.o
      }

      "allow to capture for white(left move)" in {
        grid.addWhitePieceBoard(1,8)
        grid.addBlackPieceBoard(2,7)
        grid.movePiece(1,8,3,6) shouldEqual true
        grid.StoneAtBoard(1,8) shouldEqual Stone.empty
        grid.StoneAtBoard(2,7) shouldEqual Stone.empty
        //grid.StoneAtBoard(3,6) shouldEqual Stone.o
      }

      "allow to capture for black(right move)" in {
        grid.currentPlayer = Player.black
        grid.addBlackPieceBoard(8,8)
        grid.addWhitePieceBoard(7,7)
        grid.movePiece(8,8,6,6) shouldEqual true
        grid.StoneAtBoard(8,8) shouldEqual Stone.empty
        grid.StoneAtBoard(7,7) shouldEqual Stone.empty
        grid.StoneAtBoard(6,6) shouldEqual Stone.x
      }

      "allow to capture for black(left move)" in {
        grid.addBlackPieceBoard(8,1)
        grid.addWhitePieceBoard(7,2)
        grid.movePiece(8,1,6,3) shouldEqual true
        grid.StoneAtBoard(8,1) shouldEqual Stone.empty
        grid.StoneAtBoard(7,2) shouldEqual Stone.empty
        grid.StoneAtBoard(6,3) shouldEqual Stone.x
      }
      */
      }

    }

  }


