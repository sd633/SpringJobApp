package com.example.springBoot03.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

//We need to put entity and data type of the primary key here while using JpaRepository
//The below one line will automatically generate the implementation in the run time
public interface JobRepository extends JpaRepository<Job, Long> {

}
