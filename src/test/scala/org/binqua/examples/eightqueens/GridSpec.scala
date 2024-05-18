package org.binqua.examples.eightqueens

import munit.FunSuite

class GridSpec extends FunSuite {

  test(
    "possibleQueenPositionsAtColumn for grid of size 4 and no queen yet returns all first column"
  ) {
    //00 10 20 30
    //01 11 21 31
    //02 12 22 32
    //03 13 23 33
    assertEquals(
      Grid(gridSize = 4, queensPositions = List.empty)
        .possibleQueenPositionsAtColumn(columnIndex = 0),
      List(
        (0, 0),
        (0, 1),
        (0, 2),
        (0, 3)
      )
    )
  }

  test(
    "possibleQueenPositionsAtColumn for grid of size 4 and queen at 0,0 returns no locations"
  ) {
    //0,0 1,0 2,0 3,0
    //0,1 1,1  21  31
    //0,2 12  2,2  32
    //0,3 13  23  3,3
    assertEquals(
      Grid(gridSize = 4, queensPositions = List.empty)
        .newGridWithQueenAt((0, 0))
        .possibleQueenPositionsAtColumn(columnIndex = 0),
      List.empty
    )
  }

  test(
    "possibleQueenPositionsAtColumn for grid of size 4 and queen at 0,0 and 1,2 returns (3, 1) position only"
  ) {
    //0,0 1,0 2,0 3,0
    //0,1 1,1 2,1  31
    //0,2 1,2 2,2 3,2
    //0,3 1,3 2,3 3,3
    assertEquals(
      Grid(gridSize = 4, queensPositions = List.empty)
        .newGridWithQueenAt((0, 0))
        .newGridWithQueenAt((1, 2))
        .possibleQueenPositionsAtColumn(columnIndex = 3),
      List((3, 1))
    )
  }

  test("diagonalFromTopBottomFromLeftToRight with queensPosition = (0, 0), gridSize = 4 works") {
    //00 10 20 30
    //01 11 21 31
    //02 12 22 32
    //03 13 23 33
    assertEquals(
      Grid.diagonalFromTopBottomFromLeftToRight(queensPosition = (0, 0), gridSize = 4),
      List(
        (0, 0),
        (1, 1),
        (2, 2),
        (3, 3)
      )
    )
  }

  test("diagonalFromTopBottomFromLeftToRight(queensPosition = (0, 1), gridSize = 4) it works") {
    //00 10 20 30
    //01 11 21 31
    //02 12 22 32
    //03 13 23 33
    assertEquals(
      Grid.diagonalFromTopBottomFromLeftToRight(queensPosition = (0, 1), gridSize = 4),
      List(
        (0, 1),
        (1, 2),
        (2, 3)
      )
    )
  }

  test(
    "Grid.diagonalFromBottomUpFromLeftToRight(queensPosition = (0, 1), gridSize = 4) it works"
  ) {
    //00 10 20 30
    //01 11 21 31
    //02 12 22 32
    //03 13 23 33
    assertEquals(
      Grid.diagonalFromBottomUpFromLeftToRight(queensPosition = (0, 1), gridSize = 4),
      List((0, 1), (1, 0))
    )
  }

  test("pretty print") {
    val expected = """| X  +  +  +
                      | +  +  +  +
                      | +  X  +  +
                      | +  +  +  +""".stripMargin

    assertEquals(Grid(4, List((0, 0), (1, 2))).prettyPrint, expected)
  }

}
