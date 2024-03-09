/*
class Solution{
    public int getCommon(int[] nums1, int[] nums2){
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        while(i<n && j<m){
            if(nums1[i] <nums2[j]){
                i++;
            } else if(nums1[i]>nums2[j]){
                j++;
            } else{
                return nums[i];
            }
        }
        return -1;
    }
}

*/
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: nums2){
            if(map.containsKey(num) && map.get(num)>0){
                return num;
            }
        }
        return -1;
    }
}