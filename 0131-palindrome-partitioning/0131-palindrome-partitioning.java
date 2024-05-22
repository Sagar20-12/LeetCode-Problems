class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solvedfs(0, s, list, temp);
        return list;
    }
    public void solvedfs(int index, String s, List<List<String>> list, List<String> temp){
        if(index == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                solvedfs(i+1, s, list, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}