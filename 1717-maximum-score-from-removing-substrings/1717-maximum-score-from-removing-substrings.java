class Solution {
    String str;
    public int removeSubstring(String pair, int score){
        int totalScore = 0;
        Stack<Character> st = new Stack<>();
        char firstChar = pair.charAt(0);
        char secChar = pair.charAt(1);
        for(char ch : str.toCharArray()){
            if(ch == secChar && !st.isEmpty() && st.peek() == firstChar){
                totalScore += score;
                st.pop();
            } else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        str = sb.toString();
        return totalScore;
    }
    public int maximumGain(String s, int x, int y) {
        str = s;
        String first = (x > y) ? "ab" : "ba";
        String sec = (first.equals("ab"))? "ba" : "ab";
        int score = 0;
        //first pass
        score = removeSubstring(first, Math.max(x,y));

        // second pass
        score += removeSubstring(sec, Math.min(x, y));
        return score;
    }

}