class Solution {
    public String largestGoodInteger(String num) {
        int i = 9;
        while(i>=1){
            //checking if the goodpair is in the search.
            //We are iterating from the value 9 till we reach 1;
            //If maximum value found we will return that value. Simple!
            String search = String.valueOf(111*i);
            if(num.contains(search)){
                return search;
            }
            i--;
        }
        if(num.contains("000")){
            return "000";
        }
        return "";
    }
}