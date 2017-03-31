package edu.nyu.cs9053.homework8;

// Java 8 only
import java.time.LocalDateTime;

/*
 * User: robrys
 * Date: 4/4/17
 * Time: 5:00PM
 */
public class WeightedJob extends Job {

    private final double weight;

    public WeightedJob(LocalDateTime startTime,
                       LocalDateTime finishTime,
                       double weight) {
        super(startTime, finishTime);
        this.weight = weight;
    }

    /*
        Returns the weight of the job.
    */
    public double getWeight() {
        return this.weight;
    }

}
