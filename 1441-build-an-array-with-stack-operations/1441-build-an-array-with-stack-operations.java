class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();

        int currentNum = 1;
        int ind = 0;
        while(currentNum<=n && ind < target.length){
            int num = target[ind];
            if(num == currentNum){
                list.add("Push");
                currentNum++;
                ind++;
            }
            else{
                list.add("Push");
                list.add("Pop");
                currentNum++;
            }
        }
        return list;
    }
}