package aview

import controller._
import model._
import java.util.Observer
import java.{util => ju}

class Tui(controller: Controller) extends Observer{

    //controller.add(this)

    override def update(o: ju.Observable, arg: Object): Unit = ???

    val size = 8
    
    def processInput(input: String):Unit = {
        input match {
            case "q" =>
            case "s" => controller.initStartingBoard(size)
                        controller.displayBoard()
            case "m" => controller.startGame()
                     

        }
    } 
}

