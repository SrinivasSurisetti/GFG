class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int start = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        int max_sum = sum;
        for(int i = k ; i < arr.length ; i++){
            sum = sum - arr[start] + arr[i];
            max_sum = Math.max(sum,max_sum);
            start += 1;
        }
        return max_sum;
    }
}