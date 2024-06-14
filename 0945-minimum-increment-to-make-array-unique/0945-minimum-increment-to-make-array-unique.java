class Solution {
    public int minIncrementForUnique(int[] nums) {
        // sort the nums and if the element at index is equal to previous element than add 1 to it 
         Arrays.sort(nums);
        
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i];
                nums[i] += increment;
                moves += increment;
            }
        }
        
        return moves;
    }
}