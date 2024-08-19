
//subsequence sum limited supply with reconstruction

import java.util.*;
class subSequenceSum2 {
    // static Scanner sc  = new Scanner(System.in);
    static int[] nums = new int[]{0,1,2,3};//adding element 0
    static int k = 3;
//    static  int[][] dp =new int[k+1][nums.length];
    public static void  main(String[] args){
        int number  = subarraySum(nums,k);
        System.out.println(number);
    }
    public static int subarraySum(int[] nums, int k) {
        int[][] dp =new int[k+1][nums.length];
        //initializing
        for(int i=0;i<=k;i++){
            Arrays.fill(dp[i],-1);
        }
        //filling base cases
        Arrays.fill(dp[0],1);
        for(int i=1;i<=k;i++){
            dp[i][0]=0;
        }
        //calling function
        Stack<Integer> stack = new Stack<>();//stack of numbers for reconstruction
        Stack<Integer> indices = new Stack<>();//stack of indices for reconstruction
        int number = solve(nums,k,nums.length-1,dp,stack,indices);
        return number;
    }

    public static int solve(int[] nums, int sum,int index, int[][] dp,Stack<Integer> stack, Stack<Integer> indices ){

        if(sum == 0) {
            System.out.println("the solution is "+stack);
            System.out.println("the indices are"+indices);
            return 1;
        }
        if(index < 0) return 0;
        if(dp[sum][index]!=-1){
            return dp[sum][index];
        }
        int notInclude = solve(nums, sum, index-1,dp,stack,indices);
        int include = 0;
        if(sum>=nums[index]){
            stack.push(nums[index]);
            indices.push(index);
            include = solve(nums, sum - nums[index] , index-1,dp,stack,indices);
            stack.pop();
            indices.pop();


        }
        dp[sum][index] = include + notInclude;
        return dp[sum][index];

    }
}