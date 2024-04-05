class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int size = sb.length();
            //if there is any character present and
            //their difference is 32(bcoz ascii values)
            if(size>0 && Math.abs(sb.charAt(size-1)-c) == 32){
                sb.deleteCharAt(size-1);
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}