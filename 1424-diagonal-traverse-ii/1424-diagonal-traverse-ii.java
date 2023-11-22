class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int sum = i + j;
                if (map.size() < sum + 1) {
                    map.add(new ArrayList<>());
                }
                map.get(sum).add(row.get(j));
                count++;
            }
        }
        int[] result = new int[count];
        int sum = 0;
        for (List<Integer> maps : map) {
            for (int i = maps.size() - 1; i >= 0; i--) {  
                result[sum++] = maps.get(i);
            }
        }
        return result;
    }
}
