package org.binqua.examples.eightqueens

import scala.annotation.tailrec

trait Resolver {

  def solve(aGrid: Grid): List[Grid]

}

object PositioningQueensFromLeftToRightResolver extends Resolver {

  def solve(aGrid: Grid): List[Grid] =
    internalSolve(aGrid = aGrid, solutionSoFar = List.empty, queensAtColumnIndex = 0)

  private def internalSolve(aGrid: Grid, solutionSoFar: List[Grid], queensAtColumnIndex: Int): List[Grid] =
    if (aGrid.isSolved) aGrid :: solutionSoFar
    else {
      val freeLocationsAtColumnIndex = aGrid.possibleQueenPositionsAtColumn(queensAtColumnIndex)
      solveByColumnMovingLeftToRight(aGrid, freeLocationsAtColumnIndex, solutionSoFar, queensAtColumnIndex)
    }

  @tailrec
  private def solveByColumnMovingLeftToRight(
      grid: Grid,
      freeLocations: List[(Int, Int)],
      solutionsSoFar: List[Grid],
      queensAtColumnIndex: Int
  ): List[Grid] =
    freeLocations match {
      case ::(newQueenPosition, locationsLeft) =>
        val newGrid = grid.newGridWithQueenAt(newQueenPosition)
        val newSolutions = internalSolve(newGrid, solutionsSoFar, queensAtColumnIndex = queensAtColumnIndex + 1)
        solveByColumnMovingLeftToRight(grid, locationsLeft, newSolutions, queensAtColumnIndex)
      case Nil => solutionsSoFar
    }

  def prettyPrint(grids: List[Grid]): String = {
    grids.zipWithIndex
      .map({ case (grid, index) =>
        s"${grid.prettyPrint}\nsol. ${(index + 1)}"
      })
      .mkString("\n-----\n")
  }

}
