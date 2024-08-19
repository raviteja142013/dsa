//Number of edits to convert S1 into S2. three options: edit, delete, add character
import java.util.*;
public class EditDistance {
    static String s1 = "abcd";
    static String s2 = "aedee";
    static int i = s1.length();
    static int  j = s2.length();
    static int[][] dp = new int[i+1][j+1];
    public static void main(String[] args){

        for( int k =0;k<dp.length;k++){
            Arrays.fill(dp[k],-1);
        }
        int minEditDistance = solve(i,j);
        System.out.println(minEditDistance);
    }
    public static int solve(int k, int l){
        //base
        if(k==0) return dp[k][l] = l; //l elements remaining
        if(l==0) return dp[k][l] = k;
        //dp check
        if(dp[k][l]!=-1){
            return dp[k][l];
        }
        //transition
        if(s1.charAt(k-1)==s2.charAt(l-1)){
          dp[k][l] = solve(k-1,l-1);
            return dp[k][l];
        }
        else {
            int edit = 1+solve(k-1,l-1);
            int delete = 1+solve(k-1,l);
            int add = 1+solve(k,l-1);
            int min1 = Math.min(edit,delete);
            dp[k][l] = Math.min(min1,add);
            return dp[k][l];
        }

    }
}
