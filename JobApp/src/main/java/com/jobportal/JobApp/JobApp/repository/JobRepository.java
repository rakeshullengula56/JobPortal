package com.jobportal.JobApp.JobApp.repository;

import com.jobportal.JobApp.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<JobPost,Integer> {

}
