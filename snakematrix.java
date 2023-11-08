package GeeksForGeeks;

import java.util.ArrayList;

public class snakematrix {
   static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
         ArrayList<Integer> list = new ArrayList<>();
         boolean flag=true;
        for (int j = 0; j < matrix.length; j++) {
            if (flag==true) { 
                for (int i = 0; i < matrix[j].length; i++) {
                    list.add(matrix[j][i]);
                }
                flag=false;
            } else {
                for (int i = matrix[j].length - 1; i >= 0; i--) {
                    list.add(matrix[j][i]);
                }
                flag=true;
            }
        }
        return list;
    }
    
}
