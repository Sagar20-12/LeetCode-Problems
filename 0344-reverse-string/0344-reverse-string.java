class Solution {
    public void reverseString(char[] s) {
        int leftp = 0;
        int rightp = s.length - 1;
        while(leftp<rightp){
            char temp = s[leftp];
            s[leftp] = s[rightp];
            s[rightp]= temp;
            leftp++;
            rightp--;
        }
        
    }
}