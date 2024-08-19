////DP- Assignment 1 Tiling Corridor :tilingProblem_recusionDP

import java.util.*;
public class tilingProblem_recusionDP {

    static Scanner sc= new Scanner(System.in);
    static int n= sc.nextInt();
    static long[] arr = new long[n+1];


    public static void main(String[] args) {


        Arrays.fill(arr,-1);
        if(n==0) System.out.println(0);
        else if(n==1) System.out.println(1);
        else if(n==2) System.out.println(2);
        else {

            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            System.out.println(tile(n));
        }



    }
    public static long tile(int n){
        if(arr[n]!=-1){
            return arr[n];
        }
        else{
            arr[n] = (tile(n-1)+tile(n-2))%1000000007;
            return arr[n];
        }
    }
}