package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.JobDAO;
import com.journaldev.spring.model.Assignment;
import com.journaldev.spring.model.Job;

@Service
public class JobServiceImpl implements JobService {
	
	private JobDAO jobDAO;
	
	public void setJobDAO(JobDAO jobDAO) {  
		this.jobDAO = jobDAO;
	}

	@Override
	@Transactional
	public List<Job> listJobs() {
		return this.jobDAO.listJobs();
	}

	@Override
	@Transactional
	public void addJob(Job j) {
		this.jobDAO.addJob(j);
	}
	
	@Override
	@Transactional
	public void updateJob(Job j) {
		this.jobDAO.updateJob(j);
	}
	
	@Override
	@Transactional
	public void deleteJob (int id){
		this.jobDAO.deleteJob(id);
	}

	@Override
	@Transactional
	public Job getJobById(int jobId) {
		// TODO Auto-generated method stub
		return this.jobDAO.getJobById(jobId);
	} 
	@Override
	@Transactional
	public void addAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		 this.jobDAO.addAssignment(assignment);
	} 
}
