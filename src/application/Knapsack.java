package application;

public class Knapsack {
    private final double maxValue;
    private final double[] values, weights, dp;

    public Knapsack(double[] values, double[] weights, double maxWeight) {
        assert values.length == weights.length && maxWeight > 0;
        this.values = values;
        this.weights = weights;
        this.dp = new double[values.length];
        this.maxValue = getMaxValues(values.length - 1, maxWeight);
    }

    private double getMaxValues(int index, double maxWeight) {
        if (index == 0 || maxWeight == 0) return 0;
        if (dp[index] != 0) return dp[index];
        if (weights[index] > maxWeight) return dp[index] = getMaxValues(index - 1, maxWeight);
        double taken = getMaxValues(index - 1, maxWeight - weights[index]) + values[index];
        double notTaken = getMaxValues(index - 1, maxWeight);
        return dp[index] = Math.max(taken, notTaken);
    }

    public double maxValue() {
        return maxValue;
    }
}
