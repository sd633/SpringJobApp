package com.example.springBoot03.jobs.impl;

import com.example.springBoot03.jobs.Job;
import com.example.springBoot03.jobs.JobRepository;
import com.example.springBoot03.jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    @Override
    public String createJob(Job job){
        jobRepository.save(job);
        return "Job added successfully";
    }

    @Override
    public Job findById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id,Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
