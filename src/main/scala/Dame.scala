package scala

import model.{FieldCreator, Grid, Matrix, Move, Player, Stone}
import controller._
import aview.Tui

def main(args: Array[String]) = {
    val game = new Grid(8)
    while(!finished()){
        if(currentPlayer.equals(Player.white)){
            print("Weiss ist am Zug: \n")
            print("Welchen Stein willst du bewegen: ")
            val Array(row,col) = readLine.split(" ").map(_.toInt)
            //val row = rowS.toInt
            //val col = colS.toInt
            //val Array(row,col) = readLine.split(" ").map(_.toInt)
            print("Wohin: ")
            val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
            if(movePiece(size-row, col-1, size-rowDest, colDest-1)) {
            displayBoard()
            currentPlayer = Player.black
            }
        }else if(currentPlayer.equals(Player.black)){
            print("Schwarz ist am Zug: \n")
            print("Welchen Stein willst du bewegen: ")
            val Array(row,col) = readLine.split(" ").map(_.toInt)
            print("Wohin: ")
            val Array(rowDest, colDest) = readLine.split(" ").map(_.toInt)
            if(movePiece(size-row, col-1, size-rowDest, colDest-1)) {
            displayBoard()
            currentPlayer = Player.white
            }
        }
        } 
    }