package com.aiJobApplication.controller;

import com.aiJobApplication.model.Job;
import com.aiJobApplication.service.JobScrapingService;
import com.aiJobApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobScrapingService jobScrapingService;

    @PostMapping
    public Job addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/scrape")
    public String scrapeJobs(){
        String url = "https://jobs.github.com/positions";
        jobScrapingService.scrapeJobs(url);
        return "Job Scraping Started";
    }
}
