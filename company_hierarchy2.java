//A16: DFS & Trees
//Company Hierarchy :
//using time thory
import java.util.ArrayList;
import java.util.Scanner;
public class company_hierarchy2{
    static int n;
    static ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
    static int[][] inout;
    static int num;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0;i<=n;i++){
            adjl.add(new ArrayList<Integer>());
        }
        int p;
        for(int i=2;i<=n;i++){
            p = sc.nextInt();
            adjl.get(i).add(p);
            adjl.get(p).add(i);
        }
        inout = new int[n][2];
        inout[0][0]=0;
        num = 1;
        DFS(1);
        inout[0][1] = num;
        int result;
        for(int i=0;i<n;i++){
            result = ((inout[i][1]-inout[i][0]-1)/2);//we are including only the nodes under the current node
            System.out.print(result+" ");
        }
    }

    public static void DFS(int root){
//        Integer transit ;
        inout[root-1][0] = num;
        num++;
        for(Integer transit: adjl.get(root)){
            if(inout[transit-1][0]==0){

                DFS(transit);
                inout[transit-1][1] = num; num++;
            }
        }
    }
}