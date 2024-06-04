// class Solution {
//     public int longestPalindrome(String s) {
//         int count = 0;
//         int left = 0;
//         int right = s.length()-1;
//         while(left < right){
//             if(s.charAt(left) == s.charAt(right)){
//                 count++;
//                 left++;
//                 right--;
//             } 
//         }
//         return count;
        
//     }
// }

class Solution{
    public int longestPalindrome(String s){
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                len+=2;
            } else{
                set.add(c);
            }

        }
        if(!set.isEmpty()){
            len+=1;
        }
        return len;
    }
}