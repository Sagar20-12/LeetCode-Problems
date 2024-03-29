/* class Solution {
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
*/
class Solution {
    public String frequencySort(String s) {

        // Here we have created HashMap to store the frequency of the elements.
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        // Function to sort the character based on their frequency
        TreeMap<Integer, List<Character>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (!sortedMap.containsKey(freq)) {
                sortedMap.put(freq, new ArrayList<>());
            }
            sortedMap.get(freq).add(key);
        }
 
        StringBuilder res = new StringBuilder();
        for (int freq : sortedMap.keySet()) {
            List<Character> characters = sortedMap.get(freq);
            for (char c : characters) {
                int count = map.get(c);
                for (int i = 0; i < count; i++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
