import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.{Grid, Stone, Matrix, Player}

class GridSpec extends AnyWordSpec {

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

      "allow adding white pieces" in {
        grid.addWhitePiece(1, 1)
        grid.StoneAt(1, 1) shouldEqual Stone.o
      }

      "allow adding black pieces" in {
        grid.addBlackPiece(2, 2)
        grid.StoneAt(2, 2) shouldEqual Stone.x
      }

      "allow removing pieces" in {
        grid.removePiece(1, 1)
        grid.StoneAt(1, 1) shouldEqual Stone.empty
      }

      "allow moving pieces" in {
        grid.addWhitePiece(grid.size-4, 3)
        grid.removePiece(grid.size-5,4)
        grid.currentPlayer = Player.white
        grid.movePiece(4, 4, 5, 5) shouldEqual true
        grid.StoneAtBoard(5,5) shouldEqual Stone.o
      }

      "not allow illegal moves" in {
        //no Piece
        grid.addWhitePiece(grid.size-5,4)
        grid.removePiece(grid.size-4,3)
        grid.movePiece(5, 5, 4, 4) shouldEqual false
        //illegal Move
        grid.addWhitePiece(grid.size-5,4)
        grid.removePiece(grid.size-4,3)
        grid.movePiece(5, 5, 4, 4) shouldEqual false
        //Already Occupied
        grid.addWhitePiece(grid.size-5,4)
        grid.addWhitePiece(grid.size-6,5)
        grid.movePiece(5, 5, 6, 6) shouldEqual true
        
      }

    }

  }

}
