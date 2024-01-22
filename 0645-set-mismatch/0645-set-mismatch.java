//For brute force approach we can use Binary search in this.
/* class Solution {
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
*/


// Optimal Approach using HashMap

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = {1,1}; 
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< n ;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int i = 1; i< n+1 ;i++){
            if(map.containsKey(i)){
                if (map.get(i) == 2){
                    arr[0] = i;
                }
            }
            else{ 
                arr[1] = i;
            }
        }
        return arr;
    }
}
