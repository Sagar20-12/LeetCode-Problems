import java.util.HashMap;

class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int index = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                res[index++] = num;
                if (index == 2) {
                    break;
                }
            }
        }
        
        return res;
    }
}
