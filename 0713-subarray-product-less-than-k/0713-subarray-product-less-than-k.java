class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int n = nums.length;
        int i = 0;
        int j = 0;
        int product = 1;
        int count = 0;
        while(j<n){
            product = product*nums[j];
            // product goes out of index;
            while(product>=k){
                product = product/nums[i];
                i++;
            }
            count = count + (j-i+1);
            j++;
        }
        return count;
    }
}

// Time complexity = O(2N) ~ O(N)