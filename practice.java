//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] mat = new int[n][n];
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
//        for(int i=0;i<n;i++){
//            adj.add(new ArrayList<Integer>());
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(sc.nextInt() == 1){
//                    adj.get(i).add(j+1);
//                }
//            }
//        }
//
//        for(int i=0;i<adj.size();i++){
//            System.out.print((i+1)+ ": ");
//            for(int j=0;j<adj.get(i).size();j++){
//                System.out.print(" "+adj.get(i).get(j));
//            }
//            System.out.println();
//        }
//
//    }
//}



import java.util.*;
public class practice  {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int k,l;
        for(int i=0;i<m;i++){
            k = sc.nextInt();
            l = sc.nextInt();
            //undirected graph
            adj.get(k).add(l);
            adj.get(l).add(k);
        }

        //BFS
        int[] arr = new int[n+1];
        int[] dist= new int[n+1];
//        Arrays.fill(dist,-1);
//        Arrays.fill(arr,-1);
        for(int i=0;i<=n;i++){
            arr[i] = -1;
            dist[i] = -1;
        }
        int src = sc.nextInt();
        int tar = sc.nextInt();
        //initialization
        arr[0] =src;
        dist[src] =0;
        int ptr1,ptr2;
        ptr1=0; ptr2=0;
        int nbr_curr,curr;
        //start of BFS loop
        while(arr[ptr1]!=-1){
            curr =arr[ptr1];
            ptr1++;
            for(int i=0;i<adj.get(curr).size();i++){
                nbr_curr =adj.get(curr).get(i);
                if(dist[nbr_curr]== -1){
                    ptr2++;
                    dist[nbr_curr] = dist[curr]+1;
                    arr[ptr2] = nbr_curr;

                }
            }
        }
        System.out.println(dist[tar]);

    }
}