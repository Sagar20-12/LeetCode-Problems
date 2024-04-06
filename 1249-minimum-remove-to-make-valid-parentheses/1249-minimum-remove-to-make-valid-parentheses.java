class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                continue;
            }
            if(c == '('){
                st.push(i);
            } else{
                if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                    st.pop();
                } else{
                    st.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> list = new HashSet<>(st);
        for(int i = 0; i<s.length(); i++){
            if(!list.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}