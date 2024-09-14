// return the max sub of any subarray in the given array
//Kadane DP -MAX SUM SUBARRAY
import java.sql.SQLOutput;
import java.util.*;
public class maxSumSubArray {
    public static int dp_state1(int[] nums){
        //dp state: dp[i] = max subarray sum till i, including i. dp[i] doesn't give the answer
        int[] dp =new int[nums.length];
        dp [0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i:dp){
            max = Math.max(max,i);
        }
        return max;
    }
    public static int dp_state1_so(int[] nums){
        //dp state: dp[i] = max subarray sum till i, including i

        //we can notice that in the above method, we only needed dp[i-1] i.e only previous value
        //but not the entire array. So there is scope for optimization of space. This is done as:

        int curr = nums[0];
        int maxval = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
//            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            curr = Math.max(curr+nums[i],nums[i]);
            maxval = Math.max(curr,maxval);
        }
        return maxval;
    }

    public static int dp_state2(int[] nums){
        //for every loop iteration, curr stores the value of max sum of substring from 0 to i
        int prevbest = nums[0];//previous best streak sum
        int curr = nums[0];//current best streak
        for(int i=1;i<nums.length;i++){
            curr = Math.max(nums[i],curr+nums[i]);//choosing whether to continue the streak or start new streak
            //dp[i] = curr
            prevbest = Math.max(curr,prevbest);//updating previous best streak comparing it with current streak
        }
        return prevbest;// return the max value

    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(dp_state1(nums));
        System.out.println(dp_state1_so(nums));
        System.out.println(dp_state2(nums));
    }
}
