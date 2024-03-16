class Solution {
    public int findMaxLength(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                count++;
            else
                count--;
            
            if (map.containsKey(count))
                maxLength = Math.max(maxLength, i - map.get(count));
            else
                map.put(count, i);
        }
        return maxLength;
    }
}