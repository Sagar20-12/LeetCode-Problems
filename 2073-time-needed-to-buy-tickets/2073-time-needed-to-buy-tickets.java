class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Hame yeh pata lagana hai kitne time me sab zero ho jayenge
        int n = tickets.length;
        int count = 0;
        while(true){
            for(int i = 0; i<n; i++){
                if(tickets[i]>0){
                    tickets[i]-=1;
                    count++;
                }
                if(i == k && tickets[i] == 0)
                    return count;
            }
        }
    }
}