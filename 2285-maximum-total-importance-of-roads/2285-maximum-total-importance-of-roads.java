class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans=0;
        int[] degree=new int[n];
        Arrays.fill(degree,0);
        for(int[] node: roads){
            int u=node[0];
            int v=node[1];
            degree[u]++;
            degree[v]++;
        }
        Arrays.sort(degree);
        long value=1;
        for(int i=0; i<n; i++){
            ans+=degree[i]*value;
            value++;
        }
        return ans;
    }
}