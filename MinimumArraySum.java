import java.util.Arrays;

public class MinimumArraySum {
    int dp[][][];
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        dp = new int[nums.length + 1][op1 + 1][op2 + 1];
        int sum = 0;
        for(int i : nums) sum += i;
        for(int i[][] : dp){
            for(int j[] : i) Arrays.fill(j,-1);
        }
        int reduced = solve(nums,0,op1,op2,k);
        return sum - reduced;
    }
    public int solve(int nums[],int idx,int o1,int o2,int k){
        if(idx == nums.length)
            return 0;
        if(dp[idx][o1][o2] != -1)
            return dp[idx][o1][o2];
        int n = nums[idx];
        int reduced = 0;
        reduced = solve(nums,idx+1,o1,o2,k);
        if(o1 > 0)
            reduced = Math.max(reduced,n/2 + solve(nums,idx+1,o1-1,o2,k));
        if(o2 > 0 && n >= k)
            reduced = Math.max(reduced,k + solve(nums,idx+1,o1,o2-1,k));
        if(o1 > 0 && o2 > 0){
            if((n+1)/2 >= k)
                reduced = Math.max(reduced,k + n / 2 + solve(nums,idx+1,o1-1,o2-1,k));
            else if(n >= k)
                reduced = Math.max(reduced, k + (n-k)/2 + solve(nums,idx+1,o1-1,o2-1,k));
        }
        return dp[idx][o1][o2] = reduced;
    }
}
