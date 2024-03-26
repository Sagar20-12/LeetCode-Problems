class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int miss = 1;
        for(int i = 0; i<n; i++){
            if(nums[i]> 0 && miss == nums[i]){
                miss++;
            }
        }
        return miss;
    }
}