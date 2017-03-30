- design Job.java
  start time
  finish time
- design LambdaScheduler.java
  takes a collection of jobs
  returns a compatible subset of jobs of maximum possible size

  textbook Activity Selection problem
  naive approach:
    recursively explore all permutations of jobs
  dynamic programming approach:
    recursively explore all permutations of jobs, cache subproblems
  greedy approach:
    sort jobs by earliest finishing time
    can be done recursively or iteratively

- design LambdaWeightedScheduler.java
  takes a collection of jobs
  maximize for total value (each job has an associated weight), not # of jobs
  return a compatible subset of jobs of maximum possible value

  sounds like a job for a PriorityQueue somehow




