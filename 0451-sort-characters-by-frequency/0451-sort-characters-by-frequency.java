class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        StringBuilder res = new StringBuilder();
        for(char c : list){
            int count = map.get(c);
            for(int i = 0; i<count; i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}