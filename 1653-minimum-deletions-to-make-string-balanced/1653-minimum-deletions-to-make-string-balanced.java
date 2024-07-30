// class Solution {
//     public int minimumDeletions(String s) {
//         int count = 0;
//         int bcount = 0;
//         for(char c : s.toCharArray()){
//             if(c == 'b'){
//                 bcount++;
//             } else{
//                 count = Math.min(count + 1, bcount);
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        st.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            char c = s.charAt(i);
            if((!st.isEmpty() && st.peek() == 'b') && c == 'a'){
                st.pop();
                count++;
            } 
            else{
                st.add(c);
            }
        }
        return count;
    }
}