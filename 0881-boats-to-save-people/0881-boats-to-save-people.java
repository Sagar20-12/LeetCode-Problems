class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0;
        int right = n-1;
        int count = 0;
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                count++;
                left++;
                right--;
            } else{
                count++;
                right--;
            }
        }
        return count;
    }
}