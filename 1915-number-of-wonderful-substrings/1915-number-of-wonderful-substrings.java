class Solution {
    public long wonderfulSubstrings(String word) {
        int[]count=new int[1024];
        count[0]=1;
        long res=0;
        int cum_xor=0;
        for(int i=0; i<word.length(); i++){
            cum_xor^=1<<(word.charAt(i)-'a');
            res+=count[cum_xor];
            for(int j=0; j<10; j++){
                res+=count[cum_xor^(1<<j)];
            }
            count[cum_xor]++;
        }
        return res;

    }
}