//DP- Assignment 1 Tiling Corridor :

import java.util.*;
public class TilingProblem {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        if(n==0) System.out.print(1);
        if(n==1) System.out.print(1);
        if(n==2) System.out.print(2);
        if(n>2){
            long[] dp = new long[n+1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for(int i= 3;i<=n;i++){
                dp[i] = (dp[i-1] + dp[i-2])% 1000000007;
            }
            System.out.print(dp[n]);
        }


    }
}