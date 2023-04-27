package application;

public class MatrixChainMultiplication {
    private final int minMultiplications;
    private final int[] orders;
    private final int[][] dp, brackets;
    private final StringBuilder multiplicationOrder;
    private char matrix = 'A';

    public MatrixChainMultiplication(int[] orders) {
        this.orders = orders;
        this.dp = new int[orders.length][orders.length];
        this.brackets = new int[orders.length][orders.length];
        for (int i = 0; i < orders.length; i++) {
            dp[i] = new int[orders.length];
            brackets[i] = new int[orders.length];
        }
        this.minMultiplications = minMultiplications(1, orders.length - 1);
        this.multiplicationOrder = new StringBuilder();
        setMultiplicationsOrder(1, orders.length - 1);
    }

    private int minMultiplications(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        double currentMin = Double.POSITIVE_INFINITY;
        for (int i = start; i < end; i++) {
            dp[start][i] = minMultiplications(start, i);
            dp[i + 1][end] = minMultiplications(i + 1, end);
            double provisionalMin = dp[start][i] + dp[i + 1][end] + orders[start - 1] * orders[i] * orders[end];
            if (provisionalMin < currentMin) {
                currentMin = provisionalMin;
                brackets[start][end] = i;
            }
        }
        return (int) currentMin;
    }

    private void setMultiplicationsOrder(int start, int end) {
        if (start == end) {
            this.multiplicationOrder.append(matrix++);
            return;
        }
        this.multiplicationOrder.append('(');
        setMultiplicationsOrder(start, brackets[start][end]);
        setMultiplicationsOrder(brackets[start][end] + 1, end);
        this.multiplicationOrder.append(')');
    }

    public int getMinMultiplications() {
        return minMultiplications;
    }

    public String getMultiplicationOrder() {
        return multiplicationOrder.toString();
    }
}
