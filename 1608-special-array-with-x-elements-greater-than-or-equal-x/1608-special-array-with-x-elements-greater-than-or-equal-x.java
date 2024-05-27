class Solution {
    public int specialArray(int[] nums) {
        // Here in this approach we have to return the greater than or equal to number of elements
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (count == i) {
                return count;
            }
            count = 0;
        }
        return -1;
    }
}