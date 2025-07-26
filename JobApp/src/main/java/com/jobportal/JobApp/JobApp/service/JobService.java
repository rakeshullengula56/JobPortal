package com.jobportal.JobApp.JobApp.service;

import com.jobportal.JobApp.JobApp.model.JobPost;
import com.jobportal.JobApp.JobApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;
    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);
    }

    public List<JobPost>getAllJobs(){
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int id) {
        return jobRepo.getJob(id);
    }
}