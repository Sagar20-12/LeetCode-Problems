//For better interview experience try commenting after every line this will help you to tell approach of the problem to the interviewer
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int remCost = prices[0] + prices[1];
        // we can buy chocolates when we have money
        if(remCost<=money){
            //we will return the remaining money
            return money - remCost;
        } else{
            //we will return the money we had
            return money;
        }
    }
}