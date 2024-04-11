class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k>0 && ch<st.peek()){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            // removing k elements from the right side
            if(k>0){
                st.pop();
                k--;
            } else{
                 sb.insert(0, st.pop()); // every element ko 0th index pr dala taaki reverse type ka bane
            }
            
        }
        // Removing the leading zeroes
        while(sb.length()>0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        // last case agar sab zero h
        if(sb.length() == 0){
            return "0";
        } else{
            return sb.toString();
        }
    }
}