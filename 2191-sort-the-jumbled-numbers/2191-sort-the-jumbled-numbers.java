class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            if (!hashmap.containsKey(num)) {
                hashmap.put(num, solve(num, mapping));
            }
        }
        Integer[] numboxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numboxed[i] = nums[i];
        }

        Arrays.sort(numboxed, (a, b) -> Integer.compare(hashmap.get(a), hashmap.get(b)));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numboxed[i];
        }

        return nums;
    }

    private int solve(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        int res = 0;
        int currentnum = 1;
        while (num > 0) {
            int digit = num % 10;  // to get the last digit
            num = num / 10;  // to remove the last digit
            res += mapping[digit] * currentnum;  // to convert to the given number
            currentnum = currentnum * 10;   
        }
        return res;
    }
}