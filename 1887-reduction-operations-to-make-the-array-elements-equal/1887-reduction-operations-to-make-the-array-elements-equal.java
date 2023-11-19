class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length-1; i>0; i--){
            if(nums[i-1]!=nums[i]){
                ans = ans + n - i;
            }
        }
        return ans;
    }
}