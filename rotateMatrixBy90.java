import java.util.*;

public class rotateMatrixBy90 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] matrix = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextLong();
            }
        }

        for(int j=n-1;j>=0;j--){
            for(int i=0;i<n;i++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
