//MOST PROBABLY WRONG
import java.util.*;
public class subsequenceSumIterativeDP {
    static int[] arr = {0,1,5,2};
    static int target = 5;
    public static void main(String[] args){
        int[][] dp = new int[arr.length][target+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i]<=j){
                    dp[i][j] = dp[i][j]+dp[i][j-arr[i]];
                }
            }
        }
        System.out.println(dp[arr.length-1][target]);
    }
}
