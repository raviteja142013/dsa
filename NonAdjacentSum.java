import java.util.*;
public class NonAdjacentSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,9,3 };
        int idx = arr.length-1;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);

        System.out.println(solve(arr,idx,dp));




    }
    public static int solve(int[] arr, int idx,int[] dp){
        if(idx<0){
//            System.out.println(stk);
            return 0;
        }
        if(dp[idx] != -1) return  dp[idx];
        int not_take = solve(arr, idx-1,dp);

        int take = solve(arr,idx-2,dp)+arr[idx];

        return dp[idx] =  Math.max(take, not_take);
    }


}
