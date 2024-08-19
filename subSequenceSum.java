//subsequence sum unlimited supply
import java.util.*;
class subSequenceSum {
    // static Scanner sc  = new Scanner(System.in);
    static int[] nums = new int[]{1,2,3};
    static int k = 4;
    public static void  main(String[] args){
        int number  = subarraySum(nums,k);
        System.out.println(number);
    }
    public static int subarraySum(int[] nums, int k) {
        int[][] dp =new int[k+1][nums.length+1];
        //initializing
        for(int i=0;i<=k;i++){
            Arrays.fill(dp[i],-1);
        }
        //filling base cases
        Arrays.fill(dp[0],1);
        for(int i=1;i<=k;i++){
            dp[i][nums.length]=0;
        }
        //calling function
        int number = solve(nums,k,0,dp);
        return number;
    }

    public static int solve(int[] nums, int sum,int index, int[][] dp){

        if(sum == 0) return 1;
        if(index == nums.length) return 0;
        if(dp[sum][index]!=-1){
            return dp[sum][index];
        }
        int notInclude = solve(nums, sum, index+1,dp);
        int include = 0;
        if(sum>=nums[index]){
            include = solve(nums, sum - nums[index] , index,dp);


        }
        dp[sum][index] = include + notInclude;
        return dp[sum][index];

    }
}