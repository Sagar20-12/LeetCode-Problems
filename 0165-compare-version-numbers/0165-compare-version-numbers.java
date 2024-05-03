class Solution {
    public int compareVersion(String v1, String v2) {
        String v1arr[] = v1.split("\\.");
        String v2arr[] = v2.split("\\.");
        int n1 = v1arr.length;
        int n2 = v2arr.length;
        int p1 = 0, p2 = 0;
        while(p1<n1 || p2<n2){
            int num1 = (p1<n1) ? Integer.parseInt(v1arr[p1]) : 0;
            int num2 = (p2<n2) ? Integer.parseInt(v2arr[p2]) : 0;
            if(num1!=num2){
                return (num1> num2) ? 1 : -1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}