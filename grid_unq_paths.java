import java.util.*;
public class grid_unq_paths {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        int[][] dp = new int[3][3];
//        for(int i=0;i<dp.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],0);
        }

//        System.out.println(ways(grid,0,0,dp));
        System.out.println(ways_dp(grid,dp));
    }
    public static int ways(int[][] grid,int start_x,int start_y,int[][] dp){
        if((start_x>=grid.length) || (start_y >=grid[0].length))
            return 0;
        if((start_x == grid.length-1)&&(start_y==grid[0].length-1)){
            return 1;
        }
        if(dp[start_x][start_y]!=-1) return dp[start_x][start_y];

        int down = ways(grid, start_x+1,start_y,dp);
        int right = ways(grid,start_x,start_y+1,dp);
        return dp[start_x][start_y]= down+right;
    }
    public static int ways_dp(int[][] grid,int[][] dp){

        for(int i= grid.length-1;i>=0;i--){
            int start_x = i;
            for(int j = grid[0].length-1;j>=0;j--){
                int start_y = j;
                if(start_x==grid.length-1 || (start_y==grid[0].length-1)) dp[start_x][start_y]=1;
                else
                  dp[start_x][start_y] = dp[start_x+1][start_y]+dp[start_x][start_y+1];
            }
        }
        return dp[0][0];
    }
}
