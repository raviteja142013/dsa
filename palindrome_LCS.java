
class palindrome_LCS  {
    public static int longestPalindromeSubseq(String s) {
        // char[] temp = s.toCharArray();
        String t = "";
        for(int i=s.length()-1;i>=0;i--){
            t = t+ s.charAt(i);
        }
        return LCS(t,s);
    }

    public static int LCS(String s, String t){
        int rows = s.length();
        int cols = t.length();
        int[][] dp = new int[rows+1][cols+1];
        for(int i=1;i<rows+1;i++){
            for(int j= 1;j<cols+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        String t = "babab";
        System.out.println(longestPalindromeSubseq(t));
    }
}