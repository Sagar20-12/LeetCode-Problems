class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(end<n){
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            // if window is invalid then shrink it
            while(map.get(nums[end])>k){
                map.put(nums[start], map.get(nums[start])-1);
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
}