class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        int noDrink = numBottles;
        while(noDrink >= numExchange){
            drink += noDrink / numExchange;
            noDrink = noDrink / numExchange + noDrink % numExchange;
        }
        return drink;
    }
}