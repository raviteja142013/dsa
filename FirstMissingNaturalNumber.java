//Assignment 1 : Arrays and Matrices
//[Standard] P10: Closest Refuge :
import java.util.*;

public class FirstMissingNaturalNumber {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k;
        for(int i=0;i<n;i++){
            k= sc.nextInt();
            if(k<=n)
            arr[k-1]++;
        }
        int indication=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) {
                System.out.println(i + 1);
                indication =0;
                break;
            }

        }
        if(indication==1)
            System.out.println(n+1);
    }
}


//solution2
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for(int i=0;i<n;i++)
//            arr[i] = sc.nextInt();
//
//        Arrays.sort(arr);
//        long[] arr2 = new long[n];
//
//        for(int i=0;i<n;i++)
//            arr2[i] = 0;
//
//        int counter =1;
//        for(int i=0;i<n;i++){
//            counter = arr[i];
//            if(!(counter>n)){
//                arr2[counter-1]++;
//            }
//        }
//        int c = 0;
//        for(int i=0;i<n;i++){
//            if(arr2[i]==0)
//            {System.out.println(i+1);
//                break;}
//            else{
//                c++;
//            }
//
//        }
//
//        if(c==n) //checking for the edge case like [1,2,3] answer should be 4
//            System.out.println(n+1);
//
//    }
//}