class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        q.add("0000");
        visited.add("0000");
        int count = 0;
        while(q.size()!=0){
            int n = q.size();
            for(int i = 0; i<n; i++){
                String s = q.remove();
                if(set.contains(s)) continue;
                if(s.equals(target)) return count;
                for(int j = 0; j<4; j++){
                    char ch = s.charAt(j);
                    char next, prev;
                    if(ch == '9'){
                        next = '0';
                    } else{
                        next = (char)((int)ch + 1);
                    }
                    if(ch == '0'){
                        prev = '9';
                    } else{
                        prev = (char)((int)ch - 1);
                    }
                    String s1 = s.substring(0,j) + next + s.substring(j+1);
                    String s2 = s.substring(0,j) + prev + s.substring(j+1);
                    if(!visited.contains(s1) && !set.contains(s1)){
                        q.add(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !set.contains(s2)){
                        q.add(s2);
                        visited.add(s2);
                    }
                }
            }
            count++;
        }
        return -1;
        
    }
}