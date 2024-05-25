class Solution {
    List<String> list = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        solve(0, s, set, "");
        return list;
    }
    public void solve(int index, String s, HashSet set, String temp){
        if(index == s.length()){
            list.add(temp.substring(0, temp.length()-1));
            return;
        }
        for(int i = index; i<s.length(); i++){
            String st = s.substring(index, i+1);
            if(set.contains(st)){
                solve(i+1, s, set, temp + st + " ");
            }
        }
    }
}