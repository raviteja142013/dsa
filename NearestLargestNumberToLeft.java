//STACKS & QUEUES ASSIGNMENT
//Question 2
import java.util.*;
public class NearestLargestNumberToLeft {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] inp = new long[n];
        for(int i=0;i<n;i++)
            inp[i] = sc.nextLong();

        long[] arr = new long[n];
        arr[0] = -1;

        Stack<Integer> st = new Stack<>();
        for(int i=1;i<n;i++){

            st.push(i-1);


            while((st.size()!=0)&&(inp[st.peek()]<=inp[i])){
                st.pop();
            }


            if(!(st.isEmpty())){
                arr[i] = inp[st.peek()];
            }
            else{
                arr[i] = -1;
            }



        }

        for(long i:arr)
        {System.out.print(i);
            System.out.print("\t");

        }

    }
}