package com.example.springBoot03.jobs;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    String createJob(Job job);

    Job findById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
