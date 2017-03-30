package edu.nyu.cs9053.homework8;

// Java 8 only
import java.time.LocalDateTime;

public class Job {

    private final LocalDateTime startTime;

    private final LocalDateTime finishTime;

    public Job(LocalDateTime startTime, LocalDateTime finishTime) {
        if(startTime == null ||
           finishTime == null ||
           startTime.isEqual(finishTime) ||
           startTime.isAfter(finishTime)) {
               throw new IllegalArgumentException("Invalid start or finish time provided");
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

}
