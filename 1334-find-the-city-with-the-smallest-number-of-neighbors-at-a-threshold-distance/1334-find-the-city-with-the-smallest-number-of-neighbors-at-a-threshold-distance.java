//Prerequisite is flloyd warshall algorithm 

class Solution{
 public int findTheCity(int n, int[][] edges, int distanceThreshold) {        
    int[][] grid=new int[n][n];
    for(int[] dist :grid){
        Arrays.fill(dist,Integer.MAX_VALUE);
    }
    for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        int wt=edge[2];

        grid[u][v]=wt;
        grid[v][u]=wt;
    }
    for(int via=0;via<n;via++){
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                if(grid[u][via]!=Integer.MAX_VALUE && grid[via][v]!=Integer.MAX_VALUE)
                grid[u][v]=Math.min(grid[u][v],(grid[u][via]+grid[via][v]));
            }
        }
    }
    int minReach=Integer.MAX_VALUE;
    int city=-1;
    for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<n;j++){
            if(i!=j && grid[i][j]<=distanceThreshold) 
            count++;
        }
        if(minReach>=count){
            minReach=count;
            city=i;
        }
    }
    return city;
}
}