class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flipCount = new int[n + 1];
        int currentFlips = 0;
        int flipsNeeded = 0;
        
        for (int i = 0; i < n; i++) {
            currentFlips += flipCount[i];
            if ((nums[i] + currentFlips) % 2 == 0) {
                if (i + k > n) return -1; 
                flipsNeeded++;
                currentFlips++;
                flipCount[i + k]--;
            }
        }
        
        return flipsNeeded;
    }
}