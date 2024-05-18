package org.binqua.examples.eightqueens

import munit.FunSuite
import org.binqua.examples.eightqueens.PositioningQueensFromLeftToRightResolver.solve

class PositioningQueensFromLeftToRightResolverSpec extends FunSuite {

  //Please see https://en.wikipedia.org/wiki/Eight_queens_puzzle

  test("solve with gridSize = 4 finds 2 solutions") {
    val expected =
      """| +  X  +  +
         | +  +  +  X
         | X  +  +  +
         | +  +  X  +
         |sol. 1
         |-----
         | +  +  X  +
         | X  +  +  +
         | +  +  +  X
         | +  X  +  +
         |sol. 2"""

    assertEquals(
      PositioningQueensFromLeftToRightResolver
        .prettyPrint(solve(Grid(gridSize = 4, queensPositions = List.empty))),
      expected.stripMargin
    )
  }

  test("solve with gridSize = 5 finds 10 solutions") {
    val expected =
      """| +  +  X  +  +
         | +  +  +  +  X
         | +  X  +  +  +
         | +  +  +  X  +
         | X  +  +  +  +
         |sol. 1
         |-----
         | +  +  +  X  +
         | +  X  +  +  +
         | +  +  +  +  X
         | +  +  X  +  +
         | X  +  +  +  +
         |sol. 2
         |-----
         | +  +  +  +  X
         | +  X  +  +  +
         | +  +  +  X  +
         | X  +  +  +  +
         | +  +  X  +  +
         |sol. 3
         |-----
         | +  X  +  +  +
         | +  +  +  +  X
         | +  +  X  +  +
         | X  +  +  +  +
         | +  +  +  X  +
         |sol. 4
         |-----
         | +  +  +  +  X
         | +  +  X  +  +
         | X  +  +  +  +
         | +  +  +  X  +
         | +  X  +  +  +
         |sol. 5
         |-----
         | +  X  +  +  +
         | +  +  +  X  +
         | X  +  +  +  +
         | +  +  X  +  +
         | +  +  +  +  X
         |sol. 6
         |-----
         | +  +  +  X  +
         | X  +  +  +  +
         | +  +  X  +  +
         | +  +  +  +  X
         | +  X  +  +  +
         |sol. 7
         |-----
         | +  +  X  +  +
         | X  +  +  +  +
         | +  +  +  X  +
         | +  X  +  +  +
         | +  +  +  +  X
         |sol. 8
         |-----
         | X  +  +  +  +
         | +  +  X  +  +
         | +  +  +  +  X
         | +  X  +  +  +
         | +  +  +  X  +
         |sol. 9
         |-----
         | X  +  +  +  +
         | +  +  +  X  +
         | +  X  +  +  +
         | +  +  +  +  X
         | +  +  X  +  +
         |sol. 10""".stripMargin

    assertEquals(
      PositioningQueensFromLeftToRightResolver
        prettyPrint (solve(Grid(gridSize = 5, queensPositions = List.empty))),
      expected.stripMargin
    )
  }

  test("solve with gridSize = 8 finds 92 solutions") {
    assertEquals(
      PositioningQueensFromLeftToRightResolver.solve(Grid(gridSize = 8, queensPositions = List.empty)).size,
      92
    )
  }

  test("solve with gridSize = 9 finds 352 solutions") {
    assertEquals(
      PositioningQueensFromLeftToRightResolver.solve(Grid(gridSize = 9, queensPositions = List.empty)).size,
      352
    )
  }

  test("solve with gridSize = 10 finds 724 solutions") {
    assertEquals(
      PositioningQueensFromLeftToRightResolver.solve(Grid(gridSize = 10, queensPositions = List.empty)).size,
      724
    )
  }

}
