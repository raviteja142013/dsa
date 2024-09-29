//P75: Red Alert :
//A16: DFS & Trees
import java.util.*;
public class RedAlert {
    static int[] nodes;//nodes array (to know whether a city is red or not. nodes[i]==1 implies city is red)
    static int[] visited;//nodes status -visited or not visited
    static int cap;//capacity(max number of consecutive red cities)
    static ArrayList<ArrayList<Integer>> adj;//adjacency list
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();//number of nodes
        cap = sc.nextInt();
        nodes = new int[number+1];
        for(int i=1;i<=number;i++){
            nodes[i] =sc.nextInt();
        }
        visited = new int[number+1];
        adj = new ArrayList<>();
        for(int i=0;i<=number;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<=number-1;i++){
            int k =sc.nextInt();
            int l = sc.nextInt();
            adj.get(k).add(l);

        }
        System.out.println(DFS(1,cap));




    }
    public static int DFS(int start, int limit){

        if(nodes[start] == 0) limit = cap;//resetting limit aws the streak is broken
        else{
            limit--;
        }
        if(limit==-1) return 0;//limit exhausted
        visited[start]=1;
        int sum = 0;
        if(adj.get(start).size()==0) return 1;//detecting leaf nodes
        for(Integer i: adj.get(start)){
            if(visited[i]==0)
                sum += DFS(i,limit);
        }

        return sum;



    }
}