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
}
