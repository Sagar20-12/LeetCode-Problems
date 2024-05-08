class Solution {
    public String[] findRelativeRanks(int[] score) {
        int maxV = solve(score);
        int map[] = new int[maxV + 1];
        for(int i = 0; i<score.length; i++){
            map[score[i]] = i+1; // to distinguish b/w 0 and present 
        }
        String res[] = new String[score.length]; 
        int rank = 1;
        for(int i = maxV; i>=0; i--){
            if(map[i]!=0){
                int origIndex = map[i]-1;
                if(rank == 1){
                    res[origIndex] = "Gold Medal";
                } else if(rank == 2){
                    res[origIndex] = "Silver Medal";
                } else if(rank == 3){
                    res[origIndex] = "Bronze Medal";
                } else{
                    res[origIndex] = Integer.toString(rank);
                }
                rank++;
            }
            if(rank>score.length) break;
        }
        return res;
    }
    public int solve(int[] score){
        int max = Integer.MIN_VALUE;
        for(int element : score){
            max = Math.max(max, element);
        }
        return max;
    }
}