class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for(String s : strs){
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        String sort = new String(characters);
        if(!map.containsKey(sort)){
          map.put(sort, new ArrayList<String>());
        }
        map.get(sort).add(s);
      }
      return new ArrayList<>(map.values());
        
    }
}