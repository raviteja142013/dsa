import java.util.*;
//Arrays.clone
//try k jumps
public class FrogJump {

    public static void main(String[] args) {
        int[] cost = new int[]{30,10,60,10,60,50};
        int[] dp = new int[cost.length];
//        Arrays.fill(dp,-1);
        int[] cost2 = cost.clone();
        System.out.println(Arrays.toString(cost2));
//        System.out.println(jump(cost,0,dp));
        dp[cost.length-1]=0;
        for(int i=cost.length-2;i>=0;i--){
            int j1 =Integer.MAX_VALUE,j2=Integer.MAX_VALUE;
            if(i+1<=cost.length-1)
                j1 = dp[i+1]+Math.abs(cost[i]-cost[i+1]);

            if(i+2<=cost.length-1)
                j2 = dp[i+2]+Math.abs(cost[i]-cost[i+2]);
            dp[i] = Math.min(j1,j2);
        }
        System.out.println(dp[0]);
    }
    public static int jump(int[] cost,int idx, int[] dp){
        if(idx == cost.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int j1 =Integer.MAX_VALUE,j2=Integer.MAX_VALUE;
        if(idx+1<=cost.length-1)
            j1 = jump(cost,idx+1,dp)+Math.abs(cost[idx]-cost[idx+1]);
        if(idx+2<=cost.length-1)
            j2 = jump(cost,idx+2,dp)+Math.abs(cost[idx]-cost[idx+2]);
        int min = Math.min(j1,j2);
        return dp[idx]=min;

    }
}
