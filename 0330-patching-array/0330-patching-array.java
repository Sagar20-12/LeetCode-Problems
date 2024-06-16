class Solution {
    public int minPatches(int[] nums, int n) {
        long lowSum = 1;
        int addNum = 0;
        int i = 0;
        while(lowSum <= n){
            if(i<nums.length && nums[i] <= lowSum){
                lowSum += nums[i];
                i++;
            } else{
                lowSum += lowSum;
                addNum++;
            }
        }
        return addNum;
    }
}