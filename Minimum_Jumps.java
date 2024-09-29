//P72: Minimum Jumps :
//A14: BFS & TopoSort
import java.util.*;
public class Minimum_Jumps  {
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