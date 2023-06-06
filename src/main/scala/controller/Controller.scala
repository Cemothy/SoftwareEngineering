package controller

import model._
import java.util.Observable

class Controller(var grid:Grid) extends Observable{
    
    def initStartingBoard(size: Int): Unit = {
        grid = new FieldCreator(size).startingBoard()
        notifyObservers()
    }

    def gridToString: String = grid.toString

    def set(row: Int, col: Int, value: Stone): Unit = {
        grid.set(row,col,value)
        notifyObservers()
    }

    def startGame() : Unit = {
        grid.start()
        print((grid.toString()))
        notifyObservers
    }
    
    def displayBoard() : Unit = {
        print(grid.toString)
        notifyObservers()
    }

    /*
    def movePiece(row: Int, col: Int, rowDest: Int, colDest: Int): Unit = {
        Move.movePiece(gird,row,col,rowDest,colDest)
        notifyObservers()
    }
    */





}

