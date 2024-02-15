// Prefix sum solution
class Solution {
    public long largestPerimeter(int[] nums) {
       Arrays.sort(nums);
        int n = nums.length;
        long arr[] = new long[n];
        arr[0] = nums[0];
        long ans = -1;
        for(int i = 1 ; i<n ; i++){
            arr[i] = nums[i] + arr[i-1];
            if(i>1){
                if(arr[i-1]>nums[i]){
                ans = Math.max(ans,arr[i]);
                }
            }
        }
        return ans;
    }
}