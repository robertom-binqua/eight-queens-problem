package org.binqua.examples.eightqueens

import org.binqua.examples.eightqueens.Grid.indexesByGridSize

object Grid {

  def indexesByGridSize(gridSize: Int): List[Int] = (0 until gridSize).toList

  def diagonalFromTopBottomFromLeftToRight(queensPosition: (Int, Int), gridSize: Int): List[(Int, Int)] = {
    val indexes = indexesByGridSize(gridSize)
    val (x, y) = queensPosition
    (indexes.map(i => (x - i, y - i)) ::: indexes.map(i => (x + i, y + i)))
      .filter({ case (x, y) => x >= 0 && y >= 0 && x < gridSize && y < gridSize })
      .distinct
  }

  def diagonalFromBottomUpFromLeftToRight(queensPosition: (Int, Int), gridSize: Int): List[(Int, Int)] = {
    val indexes = indexesByGridSize(gridSize)
    val (x, y) = queensPosition
    (indexes.map(i => (x - i, y + i)) ::: indexes.map(i => (x + i, y - i)))
      .filter({ case (x, y) => x >= 0 && y >= 0 })
      .distinct
  }

}

case class Grid(gridSize: Int, queensPositions: List[(Int, Int)]) {

  val isSolved: Boolean = queensPositions.size == gridSize

  def possibleQueenPositionsAtColumn(columnIndex: Int): List[(Int, Int)] = {
    def notInPositionControlledByAQueen(pos: (Int, Int)): Boolean =
      !queensPositions
        .flatMap(pos => positionsControlledByTheQueen(pos, gridSize))
        .contains(pos)

    val ys = indexesByGridSize(gridSize)
    ys.map((columnIndex, _)).filter(notInPositionControlledByAQueen)
  }

  private def positionsControlledByTheQueen(queensPosition: (Int, Int), gridSize: Int): List[(Int, Int)] = {
    val (queenX, queenY) = queensPosition
    val indexes = indexesByGridSize(gridSize)
    val columns = indexes.map((queenX, _))
    val lines = indexes.map((_, queenY))
    val diagonals = Grid.diagonalFromTopBottomFromLeftToRight(queensPosition, gridSize) :::
      Grid.diagonalFromBottomUpFromLeftToRight(queensPosition, gridSize)

    columns ::: lines ::: diagonals
  }

  def newGridWithQueenAt(queenPosition: (Int, Int)): Grid =
    Grid(gridSize, queenPosition :: queensPositions)

  def prettyPrint: String = {
    val indexes = indexesByGridSize(gridSize)

    def lineWithGivenY(y: Int): String =
      indexes
        .map(x => if (queensPositions.contains(x, y)) " X " else " + ")
        .mkString
        .reverse
        .drop(1)
        .reverse

    indexes.map(lineWithGivenY).mkString("", "\n", "")
  }

}
