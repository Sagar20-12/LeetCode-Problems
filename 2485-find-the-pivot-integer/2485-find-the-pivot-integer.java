class Solution {
    public int pivotInteger(int n) {
        int left = 1, right = n;
        int sum = (n * (n+1))/2;
        while(left<=right){
            int mid = (left + right)/2;
            int firstSum = (mid * (mid + 1))/2;
            int secondSum = sum - firstSum + mid;
            if(firstSum == secondSum)
                return mid;
            else if(firstSum < secondSum)
                left = mid +1;
            else 
                right = mid - 1;

        }
        return -1;
    }
}