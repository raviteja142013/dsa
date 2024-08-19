//P72: Minimum Jumps :

import java.util.*;
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//no of buildings
        int m = sc.nextInt();//no of edges
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=n;i++){
            alist.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            int k = sc.nextInt();
            int l = sc.nextInt();
            alist.get(k).add(l);//undirected graph
            alist.get(l).add(k);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        //bfs algo

        int src  =sc.nextInt();
        int tar = sc.nextInt();
        dist[src] =0;
        q.offer(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int j=0;j<alist.get(curr).size();j++){
                Integer nbr = alist.get(curr).get(j);
                if(dist[nbr]==-1){
                    q.offer(nbr);
                    dist[nbr] = dist[curr]+1;
                }
            }
        }
        if(dist[tar]==-1){
            System.out.println(0);
        }else{
            System.out.println(dist[tar]);
        }
    }
}

//using arrays only
//import java.util.*;
//public class Main  {
//    public static void main(String[] args) {
//
//        Scanner sc =new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n+1);
//        for(int i=0;i<=n;i++){
//            adj.add(new ArrayList<Integer>());
//        }
//        int k,l;
//        for(int i=0;i<m;i++){
//            k = sc.nextInt();
//            l = sc.nextInt();
//            //undirected graph
//            adj.get(k).add(l);
//            adj.get(l).add(k);
//        }
//
//        //BFS
//        int[] arr = new int[n+1];
//        int[] dist= new int[n+1];
////        Arrays.fill(dist,-1);
////        Arrays.fill(arr,-1);
//        for(int i=0;i<=n;i++){
//            arr[i] = -1;
//            dist[i] = -1;
//        }
//        int src = sc.nextInt();
//        int tar = sc.nextInt();
//        //initialization
//        arr[0] =src;
//        dist[src] =0;
//        int ptr1,ptr2;
//        ptr1=0; ptr2=0;
//        int nbr_curr,curr;
//        //start of BFS loop
//        while(arr[ptr1]!=-1){
//            curr =arr[ptr1];
//            ptr1++;
//            for(int i=0;i<adj.get(curr).size();i++){
//                nbr_curr =adj.get(curr).get(i);
//                if(dist[nbr_curr]== -1){
//                    ptr2++;
//                    dist[nbr_curr] = dist[curr]+1;
//                    arr[ptr2] = nbr_curr;
//
//                }
//            }
//        }
//        System.out.println(dist[tar]);
//
//    }
//}