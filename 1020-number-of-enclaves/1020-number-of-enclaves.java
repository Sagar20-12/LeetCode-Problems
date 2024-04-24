class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1 && atplace(i, j, row, col))
                    solve(grid, i, j);
            }
        }
        int count = 0;
        for(int[] r : grid){
            for(int cValue : r){
                if(cValue == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void solve(int[][] grid, int i, int j){
        // checking the boundary condition
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        // checking for the valid moves
        solve(grid, i, j-1);
        solve(grid, i, j+1);
        solve(grid, i-1, j);
        solve(grid, i+1, j);
    }
    public boolean atplace(int i, int j, int row, int col){
        return i == 0 || j == 0 ||  i == row - 1 || j == col - 1;
    }
}
