package application;

import souvik.support.MaxPQ;

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

    public JobScheduling(Double[] profits, Integer[] deadlines) {
        assert profits.length == deadlines.length;
        MaxPQ<Job> pq = new MaxPQ<>();
        for (int i = 0; i < profits.length; i++) {
            pq.enqueue(new Job(profits[i], deadlines[i]));
        }
        boolean[] schedule = new boolean[1];
        while (!pq.isEmpty()) {
            Job job = pq.dequeue();
            int deadline = job.deadline;
            if (schedule.length <= deadline) schedule = Arrays.copyOf(schedule, deadline * 2);
            while (deadline > 0 && schedule[deadline]) deadline--;
            if (deadline == 0) continue;
            schedule[deadline] = true;
            maxProfit += job.profit;
        }
    }

    public double maxProfit() {
        return maxProfit;
    }
}
