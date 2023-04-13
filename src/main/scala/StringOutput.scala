package Aufgabe1


object StringOutput{

    val x = 3
    val y = 3

    val seperator = System.getProperty("line.separator")
    def bar(cellWitdth: Int = 3, cellNum:Int = 2) = ("+" + "-" * cellWitdth) * 3 + "+" + seperator
    val cells = "|   |   |   |" + seperator
    val mesh = (bar() + cells) * 3 + bar()

    def main(args:Array[String]) = {

        println(mesh)

    }
}

