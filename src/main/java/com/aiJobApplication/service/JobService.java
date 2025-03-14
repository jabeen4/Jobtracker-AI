package com.aiJobApplication.service;

import com.aiJobApplication.model.Job;
import com.aiJobApplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job addJob(Job job){
        return jobRepository.save(job);
    }

    @Transactional
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
}
