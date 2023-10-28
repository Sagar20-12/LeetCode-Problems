class Solution {
    public boolean areNumbersAscending(String s) {
        int max = Integer.MIN_VALUE;
        String[] str = s.split(" ");
        for(String st : str){
            if(Character.isDigit(st.charAt(0))){
                int a = Integer.valueOf(st);
                if(a>max){
                    max = a;
                }
                else return false;
            }
        }
        return true;
    }
}