//P73: Adjacency Matrix to Adjacency List :
//graphs assignment 1
import java.util.*;
public class adj_mat_to_adj_list {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(int i=0;i<n;i++){
            alist.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sc.nextInt()==1){
                    alist.get(i).add(j+1);

                }

            }
        }
        for(int i=0;i<n;i++){
            System.out.print((i+1)+": ");
            for(int j=0;j<alist.get(i).size();j++){
                System.out.print(alist.get(i).get(j)+" ");

            }
            System.out.println();
        }

    }
}