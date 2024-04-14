class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;
        // Traverse right 
        for(int right = 0; right<s.length(); right++){
            //if encounter same element
            if(set.contains(s.charAt(right))){
                while(left<right && set.contains(s.charAt(right))){
                    //remove that element that is at left and increase left
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            //now add the new encountered element in the set
            set.add(s.charAt(right));
            // calculating the length of substring
            max = Math.max(max, right - left + 1);
        }
        //returning the length;
        return max;
    }
}