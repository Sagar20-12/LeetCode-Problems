class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int i = 0;
        int j = -1;
        int min = -1;
        int max = -1;
        while(i<nums.length){
            if(nums[i]<minK ||  nums[i]>maxK)
            j = i;
            if(nums[i] == minK) min = i;
            if(nums[i] == maxK) max = i;
            count += Math.max(0, Math.min(min, max) - j);
            i++;
        }
        return count;
    }
}