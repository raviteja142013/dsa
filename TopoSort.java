//Programming LIbrarires
//Graph - II: BFS & Toposort - Mega Masterclass by Manas
import java.util.*;
public class TopoSort {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();//number of nodes
        int m = sc.nextInt();//number of edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }



        int[] indeg= new int[n];//indegree of edges
        for(int i=0;i<m;i++){//adding edges and updating indegrees of those edges
            int  k = sc.nextInt();
            int l = sc.nextInt();
            adj.get(k).add(l);
            indeg[l]++;
        }
        Queue<Integer> q  = new LinkedList<>();//queue for processing
        Queue<Integer> ans  = new LinkedList<>();//queue for storing results
        for(int i=0;i<n;i++){
            if(indeg[i]==0){//initializing the process queue by populating with zero indegree nodes
                q.offer(i);
            }
        }

        //Topological sorting algorithm
        while(!q.isEmpty()){
            int c = q.poll();
            ans.offer(c);
            for(Integer k : adj.get(c)){
                indeg[k]--;
                if(indeg[k]==0){
                    q.offer(k);
                }
            }
        }
        //Printing the order
        while(!ans.isEmpty()){
            System.out.print(ans.poll()+" ");
        }

    }
}