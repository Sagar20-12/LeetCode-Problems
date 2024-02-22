class Solution {
    public int findJudge(int n, int[][] trust) {
        int count[] = new int[n+1];
        for(int i = 0; i<trust.length; i++){
            count[trust[i][1]]++;
        }
        int ans = -1;
        for(int i = 1; i<=n; i++){
            if(count[i] == (n-1)){
                ans = i;
                break;
            }
        }
        for(int i = 0; i<trust.length; i++){
            if(trust[i][0] == ans){
                return -1;
            }
        }
        return ans;
    }
}