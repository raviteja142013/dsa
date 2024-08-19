////DP- Assignment 1 Wineshelf:

import java.util.*;
public class wineShelf {
    static Scanner sc =new Scanner(System.in);
//    static int n = sc.nextInt();
    static int n = 4;

//    static int[] arr = new int[n+1];
    static int[] arr = new int[]{0,1,4,2,3};
    static long[][] profit = new long[n+1][n+1];


    public static void main(String[] args){
//        n = sc.nextInt();
//        for(int i=1;i<=n;i++){
//            arr[i] = sc.nextInt();
//        }
        for(long i=0;i<=n;i++){
            Arrays.fill(profit[(int)i],-1);
        }
        long result = solve(arr,profit, 1,n);
        System.out.println(result);
//        Queue<Integer> q =new LinkedList<>();
//        System.out.println(reconstruction(1,n,q));
    }

    public static long solve(int[] arr, long[][] profit, int start, int end){
        if(start>end) return 0;
        if(profit[start][end]!=-1) return profit[start][end];
        int year = n - (end - start);
        long price_right = year*arr[end];
        long price_left = year*arr[start];
        profit[start][end] = Math.max(solve(arr,profit,start+1,end)+price_left,solve(arr,profit,start,end-1)+price_right);
        return profit[start][end];

    }
//    public static reconstruction(int row, int col, Queue<Integer> q){
//        q.add()
//    }
}
