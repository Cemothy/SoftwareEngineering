import org.scalatest.wordspec.AnyWordSpec
import model._

class FieldCreatorSpec extends AnyWordSpec {

  "A FieldCreator" when {
    "creating a starting board" should {
      "create a grid with the correct pieces in their starting positions" in {
        val size = 8
        val creator = new FieldCreator(size)
        val grid = creator.startingBoard()
        // Check if all black pieces are in the correct starting positions
        assert(grid.StoneAt(0, 0) == Stone.x)
        assert(grid.StoneAt(0, 2) == Stone.x)
        assert(grid.StoneAt(0, 4) == Stone.x)
        assert(grid.StoneAt(0, 6) == Stone.x)
        assert(grid.StoneAt(1, 1) == Stone.x)
        assert(grid.StoneAt(1, 3) == Stone.x)
        assert(grid.StoneAt(1, 5) == Stone.x)
        assert(grid.StoneAt(1, 7) == Stone.x)
        assert(grid.StoneAt(2, 0) == Stone.x)
        assert(grid.StoneAt(2, 2) == Stone.x)
        assert(grid.StoneAt(2, 4) == Stone.x)
        assert(grid.StoneAt(2, 6) == Stone.x)
        // Check if all white pieces are in the correct starting positions
        assert(grid.StoneAt(size-1, 1) == Stone.o)
        assert(grid.StoneAt(size-1, 3) == Stone.o)
        assert(grid.StoneAt(size-1, 5) == Stone.o)
        assert(grid.StoneAt(size-1, 7) == Stone.o)
        assert(grid.StoneAt(size-2, 0) == Stone.o)
        assert(grid.StoneAt(size-2, 2) == Stone.o)
        assert(grid.StoneAt(size-2, 4) == Stone.o)
        assert(grid.StoneAt(size-2, 6) == Stone.o)
        assert(grid.StoneAt(size-3, 1) == Stone.o)
        assert(grid.StoneAt(size-3, 3) == Stone.o)
        assert(grid.StoneAt(size-3, 5) == Stone.o)
        assert(grid.StoneAt(size-3, 7) == Stone.o)
      }
    }
  }
}
