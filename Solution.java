/* 

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.

Algorithm:

1) Traverse the matrix to correctly count the # of islands

2) start with error checking
  if (grid == || grid.length == 0) return 0

3) declare return value:
  int numIslands = 0

4) Traverse the entire matrix as a grid by using a nested for loop,
  starting with i representing columns:
     for(int i = 0; i < grid.length; i++)

  Then use inner for loop to actually go thru every row in our matrix:
     for(int j = 0; j < grid[i].length == 0)

5) Use an if statement to check for a '1'
    if(grid[i][j] == '1')

6) Do a BFS/DFS on the grid to make sure you don't double count any '1's & successfully sink/flip islands you already found
    numIslands += dfs(grid, i, j);

7) return numIslands

8) Write helper function to perform DFS
    public int dfs(char [][]...)

9) Do some error checking 
  if(i < 0 || i >= grid.length;...)

  if we've gone out of bounds of array/matrix
  or the index of one of our recursive calls is '0',
  set the grid index to '0' and visit all of its adjacent
  neighbors (horizontal/vertical)
  
  grid[i][j] = '0'
  dfs(grid, i + 1, j)
  ...
  return 1 
(to account for the original island we saw during DFS recursive calls)

*/ 

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
          return 0;
        }

    int numIslands = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++){
      if(grid[i][j] == '1') {
        numIslands += dfs(grid, i, j);
      }
    }
  }

  return numIslands;
} 

public int dfs(char[][] grid, int i, int j) {
  if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
    return 0;
  }

  grid[i][j] = '0';
  dfs(grid, i + 1, j);
  dfs(grid, i - 1, j);
  dfs(grid, i, j + 1);
  dfs(grid, i, j - 1);
  return 1;
  }
}