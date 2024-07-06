class Solution {
    public int passThePillow(int n, int time) {
        int currentPillow = 1;
        int currentTime = 0;
        boolean dir = false;
        while(currentTime < time){
            if(!dir){
                currentPillow++;
            } else{
                currentPillow--;
            }
            if(currentPillow == 1 || currentPillow == n){
                dir = !dir;
            }
            currentTime++;
        }
        return currentPillow;
    }
}