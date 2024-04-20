class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] vis = new boolean[n][m];
        // to put the 0 or 1 in the array we are using arraylist
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && land[i][j] == 1){
                    int mark1 = i;
                    int mark2 = j; 
                    while(mark1<n && land[mark1][j] == 1){
                        mark1++;
                    }
                    while(mark2<m && land[i][mark2] == 1){
                        mark2++;
                    }
                    // Now start form the immediate next index where you encountered 1 first time
                    for(int k = i; k<mark1; k++){
                        for(int l = j; l<mark2; l++){
                            vis[k][l] = true;
                        }
                    }
                    //Now add the elements in the arraylist
                    res.add(new int[]{i,j,mark1-1, mark2 - 1});
                }
            }
        }
        // Now return the array after conversion which has the same size of arraylist;
            return res.toArray(new int[res.size()][]);

    }
}