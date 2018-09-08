package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Assignment;
import com.journaldev.spring.model.Job;

public interface JobService {
	
	public List<Job> listJobs();
	
	public void addJob(Job j);
	public void updateJob(Job j);
	public void deleteJob(int jobId);
	public Job getJobById (int jobId);
	public void addAssignment(Assignment a);
}
