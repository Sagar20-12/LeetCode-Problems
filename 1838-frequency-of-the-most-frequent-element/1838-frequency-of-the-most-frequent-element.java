class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 0;
        long sum = nums[j];
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            while(j < nums.length && nums[j] * (j - i + 1) <= sum+k) {
                max = Math.max(max, (j-i+1));
                j++;
                if(j < nums.length) sum += nums[j];
            }
            sum -= nums[i];
        }
        return max;
    }
}