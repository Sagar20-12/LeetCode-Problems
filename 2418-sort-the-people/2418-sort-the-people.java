// we can map names and height of the individuals
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i<heights.length; i++){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] res = new String[names.length];
        int ind = 0;
        for(int i = heights.length - 1; i>=0; i--){
            res[ind] = map.get(heights[i]);
            ind++;
        }
        return res;
    }
}