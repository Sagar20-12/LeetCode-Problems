// Flipping is giving to fool you :')'
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zero = 0;
        for(int right = 0; right<nums.length; right++){
            // check if there is any zero encountered and increase count
            if(nums[right] == 0){
                zero++;
                while(zero>k){
                    // increment left pointer and decrease zero count 
                    if(nums[left] == 0){
                        zero--;
                    }
                    left++;
                }
            }
            //calculate the len 
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}