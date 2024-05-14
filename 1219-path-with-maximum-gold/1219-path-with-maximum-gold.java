class Solution {
    int row;
    int col;
    
    public int getMaximumGold(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        int maxG = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] != 0) {
                    maxG = Math.max(maxG, dfs(i, j, grid, vis));
                }
            }
        }
        return maxG;
    }
    
    public int dfs(int roww, int coll, int[][] grid, boolean vis[][]) {
        // out of bound & vis & 0 gold
        if(roww < 0 || roww >= row || coll < 0 || coll >= col || grid[roww][coll] == 0 || vis[roww][coll]) {
            return 0;
        }
        vis[roww][coll] = true;
        int maxG = 0;
        int dir[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < 4; i++) {
            int nextRow = roww + dir[i][0];
            int nextCol = coll + dir[i][1];
            maxG = Math.max(maxG, dfs(nextRow, nextCol, grid, vis));
        }
        // try all possibilities 
        int gc = grid[roww][coll];
        vis[roww][coll] = false; 
        return gc + maxG;
    }
}
