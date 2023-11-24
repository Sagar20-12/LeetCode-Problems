class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int count = 0;
        for(int i = piles.length - 2 ;i>=n; i = i-2){
            count = count + piles[i];
        }
        return count;
    }
}