class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int dist = 0;
        int metal = 0, glass = 0, paper = 0;
        for(int i = 0; i<n; i++){
            dist+=garbage[i].length();
            if(garbage[i].contains("M"))
                metal = i;
            if(garbage[i].contains("G"))
                glass = i;
            if(garbage[i].contains("P"))
                paper = i;
        }
        for(int i = 0; i<travel.length; i++){
            if(metal>i)
                dist+=travel[i];
            if(glass>i)
                dist+=travel[i];
            if(paper>i)
                dist+=travel[i];
        }
        return dist;
    }
}