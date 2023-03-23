package application;

public class MatrixChainMultiplication {
    private final int minMultiplications;
    private final String multiplicationOrder;
    private final int[][] dp;

    public MatrixChainMultiplication(int[] orders) {
        dp = new int[orders.length][orders.length];
        for (int i = 0; i < orders.length; i++) {
            dp[i] = new int[orders.length];
        }
        minMultiplications = matrixChainMultiplication(orders, 1, orders.length - 1);
        multiplicationOrder = "";
    }

    private int matrixChainMultiplication(int[] orders, int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        double currentMin = Double.POSITIVE_INFINITY;
        for (int i = start; i < end; i++) {
            dp[start][i] = matrixChainMultiplication(orders, start, i);
            dp[i + 1][end] = matrixChainMultiplication(orders, i + 1, end);
            double provisionalMin = dp[start][i] + dp[i + 1][end] + orders[start - 1] * orders[i] * orders[end];
            currentMin = Math.min(currentMin, provisionalMin);
        }
        return (int) currentMin;
    }

    public int getMinMultiplications() {
        return minMultiplications;
    }
}
