//Hospital :
//A14: BFS & TopoSort
import java.util.*;
public class Hospital   {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();//number of towns
        int roads = sc.nextInt();//number of roads
        int[] distance = new int[nodes+1];//distance from hospital. nodes start from index 1
        Arrays.fill(distance,-1);//default
        Queue<Integer> q = new LinkedList<>();
        //set up for multi source bfs
        for(int i = 1;i<=nodes;i++){
            if(sc.nextInt()==1){
                q.offer(i);
                distance[i]=0;
            }
        }
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<=nodes;i++){
            adj_list.add(new ArrayList<>());
        }
        //populating adjacency list
        for(int i=0;i<roads;i++){
            int k = sc.nextInt();
            int l = sc.nextInt();
            adj_list.get(k).add(l);
            adj_list.get(l).add(k);
        }
        //bfs
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i =0;i<adj_list.get(curr).size();i++){
                int nbr = adj_list.get(curr).get(i);
                if(distance[nbr]==-1){
                    q.offer(nbr);
                    distance[nbr] = distance[curr] + 1;
                }
            }
        }

        int max = -1;//max distance from hospital is initialized as -1
        int flag =0;// flag to find if there is any unreachable town
        for(int i =1;i<=nodes;i++){
            if(distance[i]==-1){
                flag = 1;
            }
            max = Math.max(max, distance[i]);
        }

        if(flag==1)
            System.out.println(-1);
        else{
            System.out.println(max);
        }


    }
}

