class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idleTime = 1;
        long waiting = 0;
        for(int[] customer : customers){
            if(idleTime <=customer[0]){
                idleTime = customer[0] + customer[1];
            }
            else{
                idleTime = idleTime + customer[1];
            }
            waiting += (idleTime - customer[0]);
        }
        double avg = (waiting / (double) customers.length);
        return avg;
    }
}