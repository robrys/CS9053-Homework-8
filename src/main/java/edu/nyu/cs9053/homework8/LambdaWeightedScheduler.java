package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * User: robrys
 * Date: 4/4/17
 * Time: 5:00PM
 */
public class LambdaWeightedScheduler {

    /*
        Returns a compatible list subset of jobs of maximum possible weight.
    */
    public List<WeightedJob> maximizeWeightsOfJobs(Collection<WeightedJob> jobs) {
        // sort jobs into array list
        ArrayList<WeightedJob> sortedJobArrayList = sortJobsIntoArrayList(jobs);

        // recursively solve the problem
        Stack<WeightedJob> permutation = new Stack<WeightedJob>();
        Stack<WeightedJob> solution = new Stack<WeightedJob>();
        recursivelyPermuteJobs(sortedJobArrayList, 0, permutation, solution);
        return solution;
    }

    private ArrayList<WeightedJob> sortJobsIntoArrayList(Collection<WeightedJob> jobs) {
        // cast Collection -> Array[] -> List so can call Collections.sort()
        WeightedJob[] jobArray = jobs.toArray(new WeightedJob[0]);
        List<WeightedJob> sortedJobList = Arrays.asList(jobArray);
        Collections.sort(sortedJobList);

        // put the sorted list into an ArrayList. can be indexed, has .size()
        jobArray = sortedJobList.toArray(new WeightedJob[0]);
        ArrayList<WeightedJob> sortedJobArrayList = new ArrayList<WeightedJob>(Arrays.asList(jobArray));
        return sortedJobArrayList;
    }

    private void recursivelyPermuteJobs(ArrayList<WeightedJob> jobs,
                                        int startIndex,
                                        Stack<WeightedJob> permutation,
                                        Stack<WeightedJob> solution) {

        // recursively permute all valid job orderings
        for (int currentIndex = startIndex; currentIndex < jobs.size(); currentIndex++) {
            WeightedJob previousJob = (permutation.empty() ? null : permutation.peek());
            WeightedJob currentJob = jobs.get(currentIndex);
            if (permutation.empty() ||
                currentJob.getStartTime().isAfter(permutation.peek().getFinishTime())) {
                    permutation.push(jobs.get(currentIndex));
                    recursivelyPermuteJobs(jobs, currentIndex + 1, permutation, solution);
                    permutation.pop();
            }
        }

        // if reached the end of a permutation, sum up weights and compare solution
        double permutationWeight = sumWeightOfJobs(permutation);
        double solutionWeight = sumWeightOfJobs(solution);
        if (permutationWeight > solutionWeight) {
            solution.clear();
            solution.addAll(permutation);
        }
    }

    private double sumWeightOfJobs(Collection<WeightedJob> jobs) {
        double sum = 0d;
        for (WeightedJob job : jobs) {
            sum += job.getWeight();
        }
        return sum;
    }

}
