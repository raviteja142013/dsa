//Back to Square One :
//need to find cycles in a directed graph
//using color theory (considering 0,1,2 as colors
//Graph - III: DFS & Trees - Masterclass by Manas
//There are N cities with M one-way roads between them. You want to know whether you can start your
//journey from a city and walk along the roads and reach the same city once again. Output "YES" if
// this is NOT possible else output "NO".
import java.util.*;
public class findCyclesInDirected{
    static ArrayList<ArrayList<Integer>> adj ;
    static int[] visited;
    static String value = "YES";
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        // value = false;
        adj = new ArrayList<>();
        visited = new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        long m = sc.nextLong();
        for(long i=0;i<m;i++){
            int k = sc.nextInt();
            int l = sc.nextInt();
            adj.get(k).add(l);
        }
        int flag = 0;
        for(int i=0;i<n;i++){
            if(dfs(i)=="NO")
            {flag =1;
                break;
            }

        }
        if(flag==1)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    public static String dfs(int start){
        visited[start]=1;//node being explored
        for(Integer i : adj.get(start)){
            if(visited[i]==1)
            {value = "NO";
                return value;}
            else{
                if(visited[i]==0)//node not explored
                    dfs(i);
            }
        }
        visited[start] = 2;//node exploration complete
        return value;
    }
}