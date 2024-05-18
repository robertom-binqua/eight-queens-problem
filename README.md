# README #

### What is this repository for? ###

* This is a simple solution in scala for the famous [Eight queens puzzle](https://en.wikipedia.org/wiki/Eight_queens_puzzle)

### How do I get set up? ###

The project uses sbt. Open a sbt shell and use test task to run all the tests:

```bash
     sbt
```


```bash
 sbt:eight-queens-problem> test
org.binqua.examples.eightqueens.GridSpec:
  + possibleQueenPositionsAtColumn for grid of size 4 and no queen yet returns all first column 0.024s
  + possibleQueenPositionsAtColumn for grid of size 4 and queen at 0,0 returns no locations 0.0s
  + possibleQueenPositionsAtColumn for grid of size 4 and queen at 0,0 and 1,2 returns (3, 1) position only 0.001s
  + diagonalFromTopBottomFromLeftToRight with queensPosition = (0, 0), gridSize = 4 works 0.0s
  + diagonalFromTopBottomFromLeftToRight(queensPosition = (0, 1), gridSize = 4) it works 0.0s
  + Grid.diagonalFromBottomUpFromLeftToRight(queensPosition = (0, 1), gridSize = 4) it works 0.0s
  + pretty print 0.001s
org.binqua.examples.eightqueens.PositioningQueensFromLeftToRightResolverSpec:
  + solve with gridSize = 4 finds 2 solutions 0.026s
  + solve with gridSize = 5 finds 10 solutions 0.009s
  + solve with gridSize = 8 finds 92 solutions 0.336s
  + solve with gridSize = 9 finds 352 solutions 0.558s
  + solve with gridSize = 10 finds 724 solutions 2.964s
[info] Passed: Total 12, Failed 0, Errors 0, Passed 12
[success] Total time: 5 s, completed 18 May 2024, 15:18:51
```
