//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        if(n == 1)
        return 1;
        else if(n == 2)
        return 2;
        else{
            int count = 2;
            while(n>=3){
                if(n%2 == 0){
                n = n/2;
                count++;
                
                }
                else{
                    n--;
                    count++;
                }
            }
            return count;
        }
    }
}