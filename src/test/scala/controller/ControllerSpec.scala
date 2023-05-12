import org.scalatest.wordspec.AnyWordSpec
import controller._
import model._

class ControllerSpec extends AnyWordSpec {
  "A Controller" when {
    val grid = new Grid(8)
    val controller = new Controller(grid)

    "initialized with a starting board" should {
      "have a non-empty grid" in {
        controller.initStartingBoard(8)
        assert(controller.gridToString.nonEmpty)
      }
    }

    "setting a stone at a valid position" should {
      "update the grid with the new stone" in {
        val stone = Stone.x
        controller.set(3, 4, stone)
        assert(controller.grid.StoneAt(3, 4) == stone)
      }
    }


    "displaying the board" should {
      "print the current state of the grid" in {
        val boardString = controller.gridToString
        assert(boardString.nonEmpty)
        println(s"Current Board State:\n$boardString")
      }
    }

    "moving a piece to a valid position" should {
      "update the grid with the moved piece" in {
        controller.movePiece(3, 4, 2, 4)
        assert(controller.grid.StoneAt(2, 4) == Stone.x)
      }
    }
  }
}
