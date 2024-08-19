import java.util.*;
public class LCS_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
//        int len = LCS(s1,s2,0,0);//Recursive solution- results in TLE
        int[][] dp = new int[s1.length()][s2.length()];
//        int len = LCS_rec_dp(s1,s2,0,0,dp);
        int len = LCS_iter_dp(s1,s2);//iterative_dp
        System.out.println(len);
    }
    public static int LCS(String s1, String s2,int i, int j){
        if((i==s1.length())||(j==s2.length())){
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+ LCS(s1,s2,i+1,j+1);
        }
        else {
            return Math.max(LCS(s1,s2,i+1,j),LCS(s1,s2,i,j+1));
        }
    }
    public static int LCS_rec_dp(String s1, String s2,int i, int j,int[][] dp){
        if((i==s1.length())||(j==s2.length())){
            return 0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1+ LCS_rec_dp(s1,s2,i+1,j+1,dp);
        }
        else {
            return dp[i][j] = Math.max(LCS_rec_dp(s1,s2,i+1,j,dp),LCS_rec_dp(s1,s2,i,j+1,dp));
        }
    }
    public static int LCS_iter_dp(String s1, String s2){
        int[][] dp_iter = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp_iter.length;i++){
            for(int j=1;j<dp_iter[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp_iter[i][j] = 1+dp_iter[i-1][j-1];
                else{
                    dp_iter[i][j] = Math.max(dp_iter[i-1][j],dp_iter[i][j-1]);
                }
            }
        }
        return dp_iter[s1.length()][s2.length()];
    }
}
