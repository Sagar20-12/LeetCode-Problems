class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for(int num : nums){
            ones += num;
        }
        if(ones == 0 || ones == n){
            return 0;
        }
        int miniSwapp = Integer.MAX_VALUE;
        int zero = 0;
        for(int i = 0; i<ones; i++){
            if(nums[i] == 0){
                zero++;
            }
        }
        miniSwapp = zero;
        for(int i = ones; i<n+ones; i++){
            if(nums[i % n] == 0){
                zero++;
            }
            if(nums[(i - ones)% n] == 0){
                zero--;
            }
            miniSwapp = Math.min(miniSwapp, zero);
        }
        return miniSwapp;
    }
}