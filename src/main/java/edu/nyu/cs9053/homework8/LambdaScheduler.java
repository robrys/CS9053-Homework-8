package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/*
 * User: robrys
 * Date: 4/4/17
 * Time: 5:00PM
 */
public class LambdaScheduler {

    /*
        Returns a compatible list subset of jobs of maximum possible size.
    */
    public List<Job> maximizeNumberOfJobs(Collection<Job> jobs) {
        // sort the Collection into a list
        Job[] jobArray = jobs.toArray(new Job[0]);
        List<Job> sortedJobList = Arrays.asList(jobArray);
        Collections.sort(sortedJobList);

        // activity selection problem satisfies the greedy choice property
        // greedily take the job that finishes earliest after this job, repeatedly
        List<Job> solutionListOfJobs = new ArrayList<Job>();
        Job previousJob = null;
        for (Job job : sortedJobList) {
            if (previousJob == null ||
                job.getStartTime().isAfter(previousJob.getFinishTime())) {
                    solutionListOfJobs.add(job);
                    previousJob = job;
            }
        }
        return solutionListOfJobs;
    }

}
