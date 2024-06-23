class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int l = 0, longest = 0;

        for (int r = 0; r < nums.length; r++)
        {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            while (freq.lastKey() - freq.firstKey() > limit)
            {
                freq.put(nums[l], freq.get(nums[l]) - 1);

                if (freq.get(nums[l]) == 0)
                    freq.remove(nums[l]);
                l++;
            }

            longest = Math.max(r - l + 1, longest);
        }

        return longest;
    }
}