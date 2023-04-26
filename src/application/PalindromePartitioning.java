package application;

public class PalindromePartitioning {
    private final int minPartitions;
    private final Integer[][] dp;

    public PalindromePartitioning(String str) {
        int n = str.length();
        dp = new Integer[n][n];
        minPartitions = minPartitions(str, 0, n-1);
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    private int minPartitions(String str, int start, int end) {
        if (isPalindrome(str, start, end)) return 0;
        if (dp[start][end] != null) return dp[start][end];
        int count = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            count = Math.min(count, minPartitions(str, start, k) + minPartitions(str, k + 1, end) + 1);
        }
        return dp[start][end] = count;
    }

    public int getMinPartitions() {
        return minPartitions;
    }
}
