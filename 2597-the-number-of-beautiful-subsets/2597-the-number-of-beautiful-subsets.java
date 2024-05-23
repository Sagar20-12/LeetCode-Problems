import java.util.*;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return solve(0, nums, new ArrayList<>(), k);
    }

    private int solve(int index, int[] nums, List<Integer> temp, int k) {
        if (index == nums.length) {
            if(temp.size()>0){
                return 1;
            } else{
                return 0;
            }
        }
        
        int count = 0;
        if (!temp.contains(nums[index] - k)) {
            temp.add(nums[index]);
            count += solve(index + 1, nums, temp, k);
            temp.remove(temp.size() - 1);
        }
        count += solve(index + 1, nums, temp, k);
        return count;
    }
}
