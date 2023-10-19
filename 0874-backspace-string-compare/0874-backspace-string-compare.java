class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getStr(s).equals(getStr(t));
    }
    public String getStr(String s){
        while(s.contains("#")){
            String result = "";
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='#'){
                    if(i == 0){
                        result = s.substring(i+1);
                    }
                    else if(i == s.length()-1){
                        result = s.substring(0, i-1);
                    }
                    else{
                        result = s.substring(0, i-1) + s.substring(i+1);
                    }
                    break;
                }
            }
            s = result;
        }
        return s;
    }
}