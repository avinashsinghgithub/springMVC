package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Job;

public interface JobDAO {

	public void addJob( Job j);
	public List<Job> listJobs();
	public void updateJob(Job j);
	public void deleteJob(int jobId);
	public Job getJobById(int jobId);
}
