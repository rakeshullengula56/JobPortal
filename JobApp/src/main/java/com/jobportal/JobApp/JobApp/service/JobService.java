package com.jobportal.JobApp.JobApp.service;

import com.jobportal.JobApp.JobApp.model.JobPost;
import com.jobportal.JobApp.JobApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    public JobPost addJob(JobPost jobPost){
        return jobRepo.save(jobPost);
    }

    public List<JobPost>getAllJobs(){
        return jobRepo.findAll();
    }

    public JobPost getJob(int id) {
        return jobRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    public JobPost updateJob(JobPost jobPost) {
        JobPost jobPost1=jobRepo.findById(jobPost.getPostId()).orElseThrow(()->new RuntimeException("Not found"));
                jobPost1.setPostId(jobPost.getPostId());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
        return jobRepo.save(jobPost1);
    }

    public String deleteJob(int id) {
        JobPost jobPost1=jobRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        jobRepo.delete(jobPost1);
        return "deleted successfully";
    }
    public List<JobPost> load(){
        return new ArrayList<>(Arrays.asList(
                new JobPost(19, "Game Developer", "Create and optimize games for various platforms", 3,
                        List.of("Game Development", "Unity", "C#", "3D Modeling")),
                new JobPost(18, "Backend Developer", "Build server-side logic and databases for web applications",
                        4, List.of("Java", "Spring", "Node.js", "MongoDB")
                )));
    }
}
