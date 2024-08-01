// class Solution {
//     public int countSeniors(String[] details) {
//         int n = details.length;
//         int age = 0;
//         for(int i = 0; i<n; i++){
//             age += solve(details[i]);
//         }
//         return age;
//     }
//     public static int solve(String str){
//         String s = "";
//         s = str.substring(11, 13);
//         int totalage = Integer.parseInt(s);
//         if(totalage > 60){
//             return 1;
//         }
//         else{
//             return 0;
//         }
//     }
// }

class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            count += solve(detail);
        }
        return count;
    }

    public static int solve(String detail) {
        int age = Integer.parseInt(detail.substring(11, 13));
        return age > 60 ? 1 : 0;
    }
}
