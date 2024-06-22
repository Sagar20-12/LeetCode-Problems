class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 1) {
                sum++;
            }
            res += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}