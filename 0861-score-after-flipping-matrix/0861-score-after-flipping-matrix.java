class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero > one) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[j][i] == 0) {
                        grid[j][i] = 1;
                    } else {
                        grid[j][i] = 0;
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += solve(grid[i]);
        }
        return count;
    }
    
    public int solve(int[] arr) {
        int count = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (arr[i] == 1) {
                count += Math.pow(2, j);
            }
        }
        return count;
    }
}
