package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class LambdaScheduler {

    /*
        Returns a compatible list subset of jobs of maximum possible size.

        Since method required to type to "Collection" level,
        no way to guarantee Collection contains all unique entries.
    */
    public Collection<Job> maximizeNumberOfJobs(Collection<Job> jobs) {
        // sort the Collection into a list
        Job[] jobArray = jobs.toArray(new Job[0]);
        List<Job> jobList = Arrays.asList(jobArray);
        Collections.sort(jobList);


        return jobList;
    }

}
