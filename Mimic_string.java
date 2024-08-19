//A8: DP Pattern Recognition through Classic Problems
//4.Mimic string :
import java.util.*;
public class Mimic_string {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for(int  i =0;i<times;i++){

            int ls = sc.nextInt();
            int lt = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String t = sc.nextLine();
            int[][] dp = new int[ls+1][lt+1];

            System.out.println(minDist(s,t,ls,lt,dp));

        }

    }
    public static int minDist(String s, String t, int ls, int lt, int[][]dp){
        if(ls==0){
            return lt;
        }
        if(lt==0){
            return ls;
        }
        if(dp[ls][lt]!=0){
            return dp[ls][lt];
        }
        if(s.charAt(ls-1)==t.charAt(lt-1)){
            return minDist(s,t,ls-1,lt-1,dp);
        }
        int min1 = Math.min(1+minDist(s,t,ls,lt-1,dp),1+minDist(s,t,ls-1,lt,dp));
        dp[ls][lt] = Math.min(min1,1+minDist(s,t,ls-1,lt-1,dp));
        return dp[ls][lt];
    }
}