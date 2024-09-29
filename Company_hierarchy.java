//A16: DFS & Trees
//Company Hierarchy :
import java.util.*;
public class Company_hierarchy {
    static int nodes;
    static int[] result;
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        for(int i=0;i<=nodes;i++){
            adj.add(new ArrayList<Integer>());
        }
        result = new int[nodes+1];
        visited = new int[nodes+1];
        Arrays.fill(visited , -1);
        for(int i=2;i<=nodes;i++){
            int k = sc.nextInt();
            adj.get(k).add(i);
        }
        result = new int[nodes+1];
        q.offer(1);
        DFS(1);
        for(int i=1;i<=nodes;i++){
            System.out.print(result[i]-1+ " ");// -1 as we need only the nodes under current node
        }
    }
    public static int DFS(int start){
        visited[start] =1;
        int sum = 1;//includes the current node too
        int curr = q.poll();
        for(Integer nbr : adj.get(curr)){
//            sum = sum + 1;
            if(visited[nbr]==-1){
                q.offer(nbr);
                sum += DFS(nbr);
            }
        }
        result[start] = sum;
        return sum;


    }
}
