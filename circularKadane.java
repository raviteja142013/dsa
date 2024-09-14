public class circularKadane {
    //the below method uses doubling the array. but this is o(n2) which is bad
    public int maxSubarraySumCircular(int[] nums) {
        int[] arr = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }
        for(int i=nums.length;i<2*nums.length;i++){
            arr[i] = nums[i-nums.length];
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int start = i;
            int end = start + nums.length;
            int curr = arr[i];
            int prevbest = arr[i];
            for(int j = start+1;j<end;j++){
                curr = Math.max(curr+arr[j],arr[j]);
                prevbest = Math.max(prevbest,curr);

            }
            maxi = Math.max(prevbest,maxi);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums ={-3,-2,-3};
        System.out.println(circularsubarray(nums));
    }


    //Invert sum trick:Original Kadane was covering all cases of selection of range [i, j] where i <= j. However, circular selections being allowed our original code for Kadane misses cases where we select range [i, j] where i > j : That is, selection loops over end of array => in other words we select few integers from beginning and few from end! Now we observe that integers 'unselected' in this case still are contagious! If we choose these contagious 'unselections' as minimum then 'selected' integers will be maximum as sum of array is constant. So we use Kadane to find minimum sum contagious array (which represents 'unselections') and then subtract it from total sum of array to get Maximum selection of integers amongst cases where selection is [i, j] where i > j.
    //Edge case : Think over what if all numbers are negative? (Excercise)
    public static int circularsubarray(int[] nums){


        //calculate max sub subarray using normal kadane. if the max sum subarray
        //is in the middle of the array, this will catch

        int curr = nums[0];
        int prevbest = nums[0];
        for(int i=1;i<nums.length;i++){
            curr = Math.max(curr+nums[i],nums[i]);
            prevbest = Math.max(curr, prevbest);
        }
        int val1 = prevbest;
        //calculating min sum subarray and then subtract it from the total to get max sum
        // the below code is for covering cases where numbers are present on the edges
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total = total + nums[i];
        }
        curr = nums[0];
        prevbest = nums[0];
        for(int i=1;i<nums.length;i++){
            curr = Math.min(curr+nums[i],nums[i]);
            prevbest = Math.min(curr, prevbest);
        }
        int val2 = total - prevbest;
        if(val2==0) return val1;//edge case
        else return Math.max(val1,val2);
    }
}
