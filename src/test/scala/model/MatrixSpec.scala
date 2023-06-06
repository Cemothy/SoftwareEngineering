import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import model._

class MatrixSpec extends AnyWordSpec with Matchers {

  "A Matrix" when {
    
    val emptyMatrix = Matrix[Stone](Vector(Vector(Stone.empty)))
    val matrix = Matrix[Stone](Vector(Vector(Stone.empty, Stone.o), Vector(Stone.x, Stone.o)))
    
    "initialized with size and filling" should {
      "have the correct size" in {
        val matrix = Matrix[Stone](Vector.fill(3, 3)(Stone.empty))
        matrix.size should be (3)
      }
      "have all cells filled with the given value" in {
        val matrix = Matrix[Stone](Vector.fill(2, 2)(Stone.x))
        matrix.board.flatten.forall(_ == Stone.x) should be (true)
      }
    }
    
    "accessing a cell" should {
      "return the correct value" in {
        matrix.cell(0, 0) should be (Stone.empty)
        matrix.cell(0, 1) should be (Stone.o)
        matrix.cell(1, 0) should be (Stone.x)
        matrix.cell(1, 1) should be (Stone.o)
      }
    }
    
    "filling the matrix with a value" should {
      "return a new matrix with all cells filled with the given value" in {
        val filledMatrix = matrix.fill(Stone.x)
        filledMatrix.board.flatten.forall(_ == Stone.x) should be (true)
      }
    }
    
    "replacing a cell" should {
      "return a new matrix with the cell replaced" in {
        val replacedMatrix = matrix.replaceCell(1, 1, Stone.empty)
        replacedMatrix.cell(1, 1) should be (Stone.empty)
      }
      "not modify the original matrix" in {
        matrix.replaceCell(1, 1, Stone.empty)
        matrix.cell(1, 1) should be (Stone.o)
      }
    }
    
    "checking for a possible move" should {
      "return false if the cell is empty" in {
        emptyMatrix.possibleMove(0, 0) should be (false)
      }
      "return false if the cell contains a different stone than x" in {
        matrix.possibleMove(0, 1) should be (false)
        matrix.possibleMove(1, 1) should be (false)
      }
      "return false if the stone is at the last row" in {
        matrix.possibleMove(0, 0) should be (false)
        matrix.possibleMove(1, 0) should be (false)
      }
      "return false if the stone is at the first or last column and there is no empty cell diagonally adjacent" in {
        matrix.possibleMove(1, 1) should be (false)
        matrix.possibleMove(1, 0) should be (false)
        matrix.possibleMove(0, 1) should be (false)
      }
      /*"return true if the stone is at the first or last column and there is an empty cell diagonally adjacent" in {
        matrix.possibleMove(1, 1) should be (true)
        matrix.possibleMove(1, 0) should be (true)
        matrix.possibleMove(0, 1) should be (true)
      }*/
    }
    
  }

}
