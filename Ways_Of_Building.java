//A8: DP Pattern Recognition through Classic Problems
//3.Ways of Building :
import java.util.*;
public class Ways_Of_Building{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){

            int nums = sc.nextInt();
            int[] arr = new int[nums];
            int target = sc.nextInt();
            int[][] dp = new int[nums+1][target+1];
            for(int k=0;k<=nums;k++){

                Arrays.fill(dp[k],-1);

            }
            for(int k=0;k<nums;k++){

                arr[k] = sc.nextInt();

            }
            System.out.println(helper(arr,dp,nums,target));

        }


    }
    public static int helper(int[] arr, int[][] dp, int nums,int target){
        if(target==0){
            dp[nums][target]=1;
            return 1;
        }
        if(nums==0){
            dp[nums][target]=0;
            return 0;
        }
        if(dp[nums][target]!=-1){
            return dp[nums][target];
        }
        int not_include = helper(arr,dp,nums-1,target);
        int include =0;
        if(arr[nums-1]<=target){
            include = helper(arr,dp,nums,target-arr[nums-1]);
        }
        dp[nums][target] = (include+not_include)%1000000007;
        return dp[nums][target];

    }
}