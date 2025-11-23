package org.learning.greedy;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };

        jobSequencing(jobs);
    }

    private static void jobSequencing(Job[] jobs) {
        // Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int time = 0;
        int totalProfit = 0;

        System.out.println("Jobs done in sequence:");

        for (Job job : jobs) {
            if (job.deadline > time) {  // can schedule this job
                System.out.print("Job" + job.id + " ");
                totalProfit += job.profit;
                time++;  // move to next available time slot
            }
        }

        System.out.println("\nTotal Profit = " + totalProfit);
    }
}
