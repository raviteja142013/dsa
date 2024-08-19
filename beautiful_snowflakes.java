import java.util.*;
public class beautiful_snowflakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int k,l;
        for(int i=0;i<m;i++){
            k = sc.nextInt();
            l = sc.nextInt();
            adj.get(k).add(l);
            adj.get(l).add(k);
        }

        int size;
        int eligible;
        int wings;
        ArrayList<Integer> center;
        int count;
        int[] arr = new int[n+1];
        //gives the number of snowflakes with i wings



        for(int i=1;i<=n;i++){

            size = adj.get(i).size();
            if(size!=1){
                center = adj.get(i);
                count = 1;
                eligible = 1;
                for(int j=0;j<center.size();j++){
                    wings = center.get(j);
                    if(adj.get(wings).size()!=1){
                        eligible = 0;
                        break;
                    }
                    else{
                        count++;
                    }
                }
                if(eligible!=0) arr[count]++;
            }
        }
        count =0;
        for(int i =1;i<=n;i++){
            if(arr[i] == 1) count++;
        }
        System.out.println(count);


    }
}
