class Solution {
    public int totalMoney(int n) {
        int money = 0;
        int price = 1;
        int newcash = 1;
        int days = 1;
        while(days<=n){
            //checking if it is the complete week
            if(days%7 == 0){
                money = money + price;
                days++;
                newcash++;
                price = newcash;
            }
            //checking if it is less than the number
            if(days<=n){
                money = money + price;
                price++;
                days++;
            }
        }
        return money;

        
    }
}