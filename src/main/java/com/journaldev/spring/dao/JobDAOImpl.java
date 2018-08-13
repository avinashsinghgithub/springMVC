package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Job;

@Repository
public class JobDAOImpl implements JobDAO {
	
	SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(JobDAOImpl.class);
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public void addJob(Job j) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.save(j);
		logger.info("job created successfully, job Details="+j);
		
	}
	@Override
	public void updateJob(Job j) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.save(j);
		logger.info("job updated successfully, job Details="+j);
		
	}
	@Override
	public List<Job> listJobs() {
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Job>  jobs = session.createQuery( "from Job").list();
		for(Job j : jobs){
			logger.info("job List::"+j);
		}
		return jobs;
	}
	@Override
	public void deleteJob(int jobId) {

		Session session= this.sessionFactory.getCurrentSession();
		Job job = (Job)session.load(Job.class, jobId);
		session.delete(job);
		logger.info("job deleted successfully job details= "+job);
	}
	@Override
	public Job getJobById(int jobId) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		Job job = (Job)session.load(Job.class, jobId);
		
		return job;
	}

}
