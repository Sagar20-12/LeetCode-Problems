class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Create two hashset for storing values and for final result
       HashSet<Integer> set = new HashSet<>();
       HashSet<Integer> res = new HashSet<>();
       //Adding the numbers to HashSet
       for(int num : nums1){
           set.add(num);
       }
       for(int num: nums2){
           //Checking the Hashset if it contains the elements
           if(set.contains(num)){
               res.add(num);
           }
       }
       //Creating the new array for output
       int[] result = new int[res.size()];
       int i = 0;
       for(int num : res){
           result[i++] = num;
       }
       return result;
    }
}