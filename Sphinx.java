//Assignment 1 : Arrays and Matrices
//P7: Sphinx and Range Sums [Standard] :
import java.util.*;
public class Sphinx {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long[] pref = new long[n+1];
        arr[0] = sc.nextInt();
        pref[0]=0;
        pref[1] = arr[0];
        for(int i=1;i<n;i++){
            arr[i] = sc.nextInt();
            pref[i+1] = pref[i]+arr[i];
        }

        int q = sc.nextInt();
        int lower,upper;
        for(int i=1;i<=q;i++){
            lower =sc.nextInt();
            upper = sc.nextInt();
            if(lower<1) lower = 1;
            if(upper>n) upper =n;
            System.out.println(pref[upper]-pref[lower-1]);
        }
    }
}

//solution 2
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//
//        // System.out.println("Hello World");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        int q = sc.nextInt();
//        int[][] arr2 = new int[q][2];
//        for(int i=0;i<q;i++){
//            for(int j=0;j<2;j++){
//                arr2[i][j] = sc.nextInt();
//            }
//        }
//        long[] prefix  = new long[n+1];
//        // int[] prefix  = new int[n+1];
//        prefix[0] = 0;
//        for(int i=1;i<=n;i++){
//            prefix[i] = arr[i-1]+ prefix[i-1];
//
//        }
//        int l=0,r=0;
//        for(int i=0;i<q;i++){
//            l = arr2[i][0];
//            r = arr2[i][1];
//
//            if((l)<0) {
//                if(r>n){
//                    System.out.println(prefix[n]);
//                }else{
//                    System.out.println(prefix[r]);
//                }
//            }
//            else if(r>n)
//                System.out.println(prefix[n]);
//            else
//                System.out.println(prefix[r]-prefix[l-1]);
//
//        }
//
//
//    }
//}