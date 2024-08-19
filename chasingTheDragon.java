import java.util.Scanner;

//Assignment 1 : Arrays and Matrices
//P6: Chasing the Dragon [Advanced][Optional] :

public class chasingTheDragon{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        long n =sc.nextLong();
        long[] dist = new long[(int)n];
        long[] pref = new long[(int)n];
        dist[0] = sc.nextLong();
        pref[0] = dist[0];
        for(int i=1;i<n;i++){
            dist[i] = sc.nextLong();
            pref[i] = pref[i-1]+dist[i];
        }
        long q =sc.nextLong();
        int dir;
        long stride;
        long source = 0;
        long target;
        long min_cost;
        for(long i=0;i<q;i++){
            dir = sc.nextInt();
            stride= sc.nextLong();
            if(dir==1){
                target = (Long)(source+stride)%(Long)n;
                min_cost=Math.abs(pref[(int)target]-pref[(int)source]);
                System.out.println(Math.min(min_cost,pref[(int) (n-1)]-min_cost));
                source = target;
            }
            else{
                target = (Long)(source-stride)%(Long)n;
                if(target<0) target =target+n;
                min_cost=Math.abs(pref[(int)target]-pref[(int)source]);
                System.out.println(Math.min(min_cost,pref[(int)n-1]-min_cost));
                source = target;
            }
        }
    }
}


