package aview


import controller.Controller
import model.{Field,Player,Stone}
import java.util.Observer

class Tui(controller: Controller) extends Observer{

    controller.add(this)
    val size = 8
    val randomCells:Int = size*size/4
    
    def processInput(input: String):Unit = {
        input match {
            case "q" =>
            case "s" =>

        }
    } 


