//For brute force approach we can use Binary search in this.
import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[2];
        boolean duplicateFound = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res[0] = nums[i];
                duplicateFound = true;
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!bs(nums, i)) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public static boolean bs(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                low = mid + 1;
            else if (target < nums[mid])
                high = mid - 1;
        }
        return false;
    }
}
