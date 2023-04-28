package controller

import model._
import java.util.Observable

class Controller(var grid:Grid) extends Observable{
    
    def initStartingBoard(size: Int): Unit = {
        val field = new FieldCreator(size)
        notifyObservers()
    }

    def gridToString: String = grid.toString

    def set(row: Int, col: Int, value: Stone): Unit = {
        grid = grid.set(row,col,value)
        notifyObservers()
    }

    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Unit = {
        grid = grid.movePiece(row,col,rowDest,colDest)
        notifyObservers()
    }





}

