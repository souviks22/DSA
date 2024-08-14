package application;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    private final int[][] pointsX, pointsY, aux;
    private final double closestDistance;

    public ClosestPair(int[][] points) {
        int n = points.length;
        pointsX = new int[n][2];
        pointsY = new int[n][2];
        aux = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pointsX[i] = points[i];
            pointsY[i] = points[i];
        }
        Arrays.sort(pointsX, new XComparator());
        Arrays.sort(pointsY, new YComparator());
        closestDistance = minDist(0, n - 1);
    }

    private double minDist(int lo, int hi) {
        if (hi - lo + 1 <= 3) return naive(lo, hi, pointsY);
        for (int k = lo; k <= hi; ++k) aux[k] = pointsY[k];
        int mid = lo + (hi - lo) / 2;
        int i = lo, j = mid + 1, midX = pointsX[mid][0];
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) pointsY[j++] = aux[k];
            else if (j > hi) pointsY[i++] = aux[k];
            else if (aux[k][0] <= midX) pointsY[i++] = aux[k];
            else pointsY[j++] = aux[k];
        }
        double mini = Math.min(minDist(lo, mid), minDist(mid + 1, hi));
        int slo = -1, shi = -1;
        for (int k = lo; k <= hi; ++k) {
            if (Math.abs(pointsX[k][0] - midX) <= mini) {
                if (slo == -1) slo = k;
                shi = k;
            }
        }
        return Math.min(naive(slo, shi, pointsX), mini);
    }

    private double naive(int lo, int hi, int[][] points) {
        double mini = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; ++i) {
            for (int j = i + 1; j <= hi; ++j) {
                mini = Math.min(dist(points[i], points[j]), mini);
            }
        }
        return mini;
    }

    private double dist(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0], dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    private static class XComparator implements Comparator<int[]> {
        public int compare(int[] point1, int[] point2) {
            return Integer.compare(point1[0], point2[0]);
        }
    }

    private static class YComparator implements Comparator<int[]> {
        public int compare(int[] point1, int[] point2) {
            return Integer.compare(point1[1], point2[1]);
        }
    }

    public double getClosestDistance() {
        return closestDistance;
    }

    public static void main(String[] args) {
        int[][] points = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
        ClosestPair closestPair = new ClosestPair(points);
        System.out.println(closestPair.getClosestDistance());
    }
}
