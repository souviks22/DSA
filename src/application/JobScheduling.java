package application;

import java.util.Arrays;

public class JobScheduling {
    private double maxProfit;

    public JobScheduling(double[] profits, double[] deadlines) {
        assert profits.length == deadlines.length;
        sort(profits, deadlines);
        int n = profits.length;
        boolean[] isOccupied = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = (int) Math.min(n, deadlines[i]) - 1; j >= 0; j--) {
                if (!isOccupied[j]) {
                    maxProfit += profits[i];
                    isOccupied[j] = true;
                    break;
                }
            }
        }
    }

    public JobScheduling(double[] profits, double[] starts, double[] ends) {
        assert profits.length == starts.length && starts.length == ends.length;
        sort(ends, profits, starts);
        int n = profits.length;
        double[] netProfits = Arrays.copyOf(profits, n);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (starts[i] >= ends[j]) {
                    netProfits[i] = Math.max(netProfits[j] + profits[i], netProfits[i - 1]);
                    break;
                }
            }
        }
        maxProfit = netProfits[n - 1];
    }

    private void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort(double[] compare, double[]... rest) {
        for (int i = 0; i < compare.length; i++) {
            for (int j = i; j > 0; j--) {
                if (compare[j] >= compare[j - 1]) break;
                swap(compare, j, j - 1);
                for (double[] arr : rest) swap(arr, j, j - 1);
            }
        }
    }

    public double maxProfit() {
        return maxProfit;
    }
}
