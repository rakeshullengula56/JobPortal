package com.jobportal.JobApp.JobApp.controller;

import com.jobportal.JobApp.JobApp.model.JobPost;
import com.jobportal.JobApp.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:5173/")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping("load")
    public List<JobPost> load(){
        return jobService.load();
    }

    @GetMapping("jobPost/{id}")  //to access id in method argument use @PathVariable
    public JobPost getAllJobs(@PathVariable("id") int id){
        return jobService.getJob(id);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        return jobService.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){

        return jobService.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int id){
        return jobService.deleteJob(id);
    }
}
