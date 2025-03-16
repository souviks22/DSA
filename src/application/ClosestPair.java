package application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ClosestPair {
    private final int[][] points, aux;
    private final double closestDist;

    public ClosestPair(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        this.points = points;
        aux = new int[points.length][2];
        closestDist = minimize(0, points.length - 1);
    }

    private double minimize(int lo, int hi) {
        if (lo == hi) return Double.POSITIVE_INFINITY;
        if (hi - lo + 1 == 2) {
            if (points[lo][1] > points[hi][1]) {
                int[] temp = points[lo];
                points[lo] = points[hi];
                points[hi] = temp;
            }
            return dist(points[lo], points[hi]);
        }
        int mid = lo + (hi - lo)/2;
        int midX = points[mid][0];
        double d = Math.min(minimize(lo, mid), minimize(mid + 1, hi));
        System.arraycopy(points, lo, aux, lo, hi - lo + 1);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) points[j++] = aux[k];
            else if (j > hi) points[i++] = aux[k];
            else if (aux[i][1] < aux[j][1]) points[i++] = aux[k];
            else points[j++] = aux[k];
        }
        int n = 0;
        for (int k = lo; k <= hi; ++k) {
            if (Math.abs(points[k][0] - midX) < d) {
                aux[n++] = points[k];
            }
        }
        double mini = d;
        for (int k = 0; k < n; ++k) {
            double limit = aux[k][1] - d;
            for (int l = k-1; l >= 0 && aux[l][1] > limit; --l) {
                mini = Math.min(dist(aux[k], aux[l]), mini);
            }
        }
        return mini;
    }

    private double dist(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getClosestDistance() {
        return closestDist;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int[][] points = new int[n][];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int x = random.nextInt(-n,n);
            int y = random.nextInt(-n,n);
            points[i] = new int[]{x,y};
        }
        ClosestPair closestPair = new ClosestPair(points);
        System.out.println(closestPair.getClosestDistance());
    }
}
