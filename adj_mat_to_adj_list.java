//P73: Adjacency Matrix to Adjacency List :
//graphs assignment 1
import java.util.*;
public class adj_mat_to_adj_list{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        //adding n+1 levels which includes level 0. to convert to 1 index type
        for(int i=0;i<=n;i++){
            alist.add(new ArrayList<Integer>());
        }
        //i =1 implies starting from node 1. j = 1 implies starting from node 1
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(sc.nextInt()==1){
                    alist.get(i).add(j);

                }

            }
        }
        //i =1 implies starting from node 1. j = 0 implies that we are accessing the first element in the list
        for(int i=1;i<=n;i++){
            System.out.print(i+": ");
            for(int j=0;j<alist.get(i).size();j++){
                System.out.print(alist.get(i).get(j)+" ");

            }
            System.out.println();
        }

    }
}