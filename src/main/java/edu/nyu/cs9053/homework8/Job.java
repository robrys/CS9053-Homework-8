package edu.nyu.cs9053.homework8;

// Java 8 only
import java.time.LocalDateTime;

/*
 * User: robrys
 * Date: 4/4/17
 * Time: 5:00PM
 */
public class Job implements Comparable<Job> {

    private final LocalDateTime startTime;

    private final LocalDateTime finishTime;

    public Job(LocalDateTime startTime, LocalDateTime finishTime) {
        if(startTime == null || finishTime == null) {
            throw new NullPointerException();
        }
        if (startTime.isEqual(finishTime) || startTime.isAfter(finishTime)) {
            throw new IllegalArgumentException("Job start time >= finish time");
        }
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    /*
        Returns the job's start time
    */
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /*
        Returns the job's finish time
    */
    public LocalDateTime getFinishTime() {
        return this.finishTime;
    }


    /*
        Implements comparable interface by comparing job *finish* time.
        Returns -1 if this < otherJob, 0 if this = otherJob, 1 if this > otherJob.
    */
    public int compareTo(Job otherJob) {
        if (otherJob == null) {
            throw new NullPointerException();
        }
        return this.finishTime.compareTo(otherJob.finishTime);
    }

}
