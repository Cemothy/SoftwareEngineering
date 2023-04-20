import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FieldSpec extends AnyWordSpec {

  "Field" should {

    "have a size of 8" in {
      Field.size shouldBe 8
    }


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

  }

}