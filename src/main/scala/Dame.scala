package scala

import model.{FieldCreator, Grid, Matrix, Move, Player, Stone}
import controller._
import aview.Tui
import scala.io.StdIn._


object Start {
  val controller = new Controller(new Grid(8))
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = ""
    print("q: Quit \n")
    print("s = StartingBoard \n")
    print("m: = Move \n")
    input = readLine()
    tui.processInput(input)
    while(!input.equals("q")){
      input = readLine()
      tui.processInput(input)
    }
  }
}