//very good code practice
//A8: DP Pattern Recognition through Classic Problems
//problem 1 :Jump Practice
import java.util.*;
public class Jump_Possibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int nums = sc.nextInt();
            int target = sc.nextInt();
            int[] arr = new int[nums];
            for(int k=0;k<nums;k++){
                arr[k] = sc.nextInt();
            }
            int[][] dp = new int[target+1][nums+1];
            for(int k=0;k<=target;k++){
                Arrays.fill(dp[k],-1);
            }

            boolean  result = helper(arr,dp,nums,target);
            if(result == true){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

    }
    public static boolean  helper(int[] arr,int[][] dp,int nums, int target){
        if(target==0)
        {
            dp[target][nums]=1;
            return true;
        }
        if(nums==0)
        {
            dp[target][nums]=0;
            return false;
        }
        if(dp[target][nums]!=-1){
            return (dp[target][nums]==0)?false:true;
        }
        boolean not_include = helper(arr,dp,nums-1,target);
        boolean include = false;
        if(arr[nums-1]<=target){
             include = helper(arr,dp,nums-1,target-arr[nums-1]);
        }
        dp[target][nums] = ((not_include||include)==true?1:0);
        return (not_include||include);
    }

}