package com.jobportal.JobApp.JobApp.repository;

import com.jobportal.JobApp.JobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {
    List<JobPost> jobPosts=new ArrayList<>(Arrays.asList(
            new JobPost(19, "Game Developer", "Create and optimize games for various platforms", 3,
                    List.of("Game Development", "Unity", "C#", "3D Modeling")),
                    new JobPost(18, "Backend Developer", "Build server-side logic and databases for web applications",
                            4, List.of("Java", "Spring", "Node.js", "MongoDB")
    )));
    public void addJob(JobPost jobPost){
        jobPosts.add(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobPosts;
    }

    public JobPost getJob(int id) {
        for(JobPost job:jobPosts){
            if(id==job.getPostId()){
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost jobPost1:jobPosts){
            if(jobPost.getPostId()==jobPost1.getPostId()){
                jobPost1.setPostId(jobPost.getPostId());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public String deleteJob(int id) {
        for(JobPost jobPost1:jobPosts){
            if(id==jobPost1.getPostId()){
                jobPosts.remove(jobPost1);
                return "removed successfully";
            }
        }
        return "No such job Found";
    }
}
