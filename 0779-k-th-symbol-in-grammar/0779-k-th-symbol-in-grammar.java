class Solution {
    public int kthGrammar(int n, int k) {
        int cnt = 0;
        while(n!=0){
            n--;
            if((k+1)%2==1)
                cnt++;
            k=(k+1)/2;
        }   
        if(cnt%2==0)
        return 0;
        return 1;
    }
}