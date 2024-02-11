// simple DFS Approach
// Its giving TLE answer
/* class Solution {
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return solve(grid, 0, 0, cols-1);
    }
    
    public int solve(int[][] grid, int currRow, int robotACol, int robotBCol) {
        
        if(robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) return 0;
        
        if(currRow == grid.length) return 0; 
        
        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];
        
        int max = 0; 
        for(int i=robotACol-1;i<=robotACol+1;i++) {
            for(int j=robotBCol-1;j<=robotBCol+1;j++) {
                if(i < j) {
                    max = Math.max(max, solve(grid, currRow+1, i, j));
                }
            }
        }
        
        result += max; 
        return result;
    }
}
*/
class Solution {

    private int[][][] solve;

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        solve = new int[rows][cols][cols]; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(solve[i][j], -1);
            }
        }
        return calculate(grid, 0, 0, cols - 1);
    }

    public int calculate(int[][] grid, int currRow, int robotACol, int robotBCol) {

        if (robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length)
            return 0;

        if (currRow == grid.length)
            return 0;

        if (solve[currRow][robotACol][robotBCol] != -1)
            return solve[currRow][robotACol][robotBCol];

        int result = 0;
        result += grid[currRow][robotACol];
        if (robotACol != robotBCol) 
            result += grid[currRow][robotBCol];

        int max = 0;
        for (int i = robotACol - 1; i <= robotACol + 1; i++) {
            for (int j = robotBCol - 1; j <= robotBCol + 1; j++) {
                max = Math.max(max, calculate(grid, currRow + 1, i, j));
            }
        }

        result += max;
        solve[currRow][robotACol][robotBCol] = result;
        return result;
    }
}
