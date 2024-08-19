import java.util.Arrays;

//Longest Bi-tonic Subsequence
public class LBTS {
    public static void main(String[] args) {
        int[] arr = {6,8,2,1,5,4,9};
        int l = arr.length;
        int[] dp_inc = new int[l];
        int[] dp_dec = new int[l];
        Arrays.fill(dp_inc,1);
        Arrays.fill(dp_dec,1);
        for(int i=1;i<l;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) dp_inc[i] = Math.max(dp_inc[i],dp_inc[j]+1);
                if(arr[i]<arr[j]) dp_dec[i] = Math.max(dp_dec[i],dp_dec[j]+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            max = Math.max(max,dp_dec[i]+dp_inc[i]-1);//-1 as same number is a part of both increasing and decreasing subsequences.
            //so two times included. so has to be removed once
        }
        System.out.println(max);
    }
}
