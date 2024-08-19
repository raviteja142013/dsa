import java.util.Arrays;

//LONGEST INCREASING SUBSEQUENCE
public class LIS {
    public static void main(String[] args) {
        int[] arr= {10,9,2,5,3,7,101,18};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);// every element is in itself an increasing subsequence
        for(int i =1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(dp[dp.length-1]);
    }
    //recursive
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] arr =new int[n+1];S
    //     arr[0] = Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++) arr[i+1] = nums[i];
    //     int out  = Sol(0,1,arr);
    //     return out;
    // }
    // public int Sol(int i,int j,int[] arr){
    //     if(j>arr.length-1) return 0;
    //     if(arr[i]>=arr[j]) return Sol(i,j+1,arr);
    //     else
    //     return Math.max(Sol(i,j+1,arr),Sol(j,j+1,arr)+1);
    // }

}
