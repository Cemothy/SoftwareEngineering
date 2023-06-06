package model

enum Stone {
    case x, o, empty

    def negate(stone: Stone): Stone = stone match {
      case `x` => o
      case `o` => x
      case `empty` => empty
    }
  }

