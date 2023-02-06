package application;

import souvik.sort.Insertion;

import java.util.Arrays;

public class JobScheduling {
    private double maxProfit;

    private class Job implements Comparable<Job> {
        public final double profit;
        public final int deadline;

        public Job(double profit, int deadline) {
            this.profit = profit;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Job that) {
            return Double.compare(this.profit, that.profit);
        }
    }

    private class WeightedJob implements Comparable<WeightedJob> {
        public final double profit;
        public final int start, end;

        public WeightedJob(double profit, int start, int end) {
            this.profit = profit;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(WeightedJob that) {
            return Integer.compare(this.end, that.end);
        }
    }

    public JobScheduling(double[] profits, int[] deadlines) {
        assert profits.length == deadlines.length;
        Job[] jobs = new Job[profits.length];
        for (int i = 0; i < profits.length; i++) jobs[i] = new Job(profits[i], deadlines[i]);
        Insertion.sort(jobs);
        boolean[] schedule = new boolean[1];
        for (int i = jobs.length - 1; i >= 0; i--) {
            int deadline = jobs[i].deadline;
            if (schedule.length <= deadline) schedule = Arrays.copyOf(schedule, deadline * 2);
            while (deadline > 0 && schedule[deadline]) deadline--;
            if (deadline == 0) continue;
            schedule[deadline] = true;
            maxProfit += jobs[i].profit;
        }
    }

    public JobScheduling(double[] profits, int[] starts, int[] ends) {
        assert profits.length == starts.length && starts.length == ends.length;
        WeightedJob[] jobs = new WeightedJob[profits.length];
        for (int i = 0; i < jobs.length; i++) jobs[i] = new WeightedJob(profits[i], starts[i], ends[i]);
        Insertion.sort(jobs);
        double[] netProfits = new double[jobs.length];
        for (int i = 0; i < netProfits.length; i++) netProfits[i] = jobs[i].profit;
        for (int i = 0; i < jobs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[i].start >= jobs[j].end) netProfits[i] = jobs[i].profit + netProfits[j];
            }
        }
        for (double profit : netProfits) {
            if (profit > maxProfit) maxProfit = profit;
        }
    }

    public double maxProfit() {
        return maxProfit;
    }
}
