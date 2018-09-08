package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Assignment;
import com.journaldev.spring.model.Job;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.JobService;
import com.journaldev.spring.service.PersonService;

@Controller
public class JobController {
	
	
	private JobService jobService;
	private PersonService personService;
	
	@Autowired
	@Qualifier(value="jobService")
	public void setJobService( JobService jobService){
		this.jobService=jobService;
	}
	@Autowired
	public void setPersonService( PersonService personService){
		this.personService=personService;
	}
	@RequestMapping(value="/jobs",method=RequestMethod.GET)
	public String listJobs(Model model){
		model.addAttribute("job", new Job());
		model.addAttribute("listJobs",this.jobService.listJobs());
		return "job";
	}
	
	@RequestMapping(value="/job/add",method=RequestMethod.POST)
	public String addJob(@ModelAttribute("job") Job j){
//		model.addAttribute("job", new Jobs());
//		model.addAttribute("listJobs",this.jobService.listJobs());
		if(j.getJobId()==0){
			this.jobService.addJob(j);
		}else{
			this.jobService.updateJob(j);
		}
		return "redirect:/jobs";
	}
	@RequestMapping(value="/job/delete/{id}",method=RequestMethod.GET)
	public String deleteJob(@PathVariable ("id") int id){
		
			this.jobService.deleteJob(id);
		
		return "redirect:/jobs";
	}
	@RequestMapping(value="/job/edit/{id}",method=RequestMethod.GET)
	public String editJob(@PathVariable ("id") int id,Model model){
		
			model.addAttribute("job",this.jobService.getJobById(id)) ;
			model.addAttribute("listJobs",this.jobService.listJobs());
		return "job";
	}
	@RequestMapping(value="/jobAssignment",method=RequestMethod.GET)
	public String jobAssignment(Model model){
			model.addAttribute("assignment" ,new Assignment());
			model.addAttribute("persons",this.personService.listPersons()) ;
			model.addAttribute("jobs",this.jobService.listJobs());
		return "jobAssignment";
	}
	@RequestMapping(value="/jobassignment",method=RequestMethod.POST)
	public String saveJobAssignment(@ModelAttribute("assignment") Assignment assignment){
			if(assignment.getAssignmentId()==0){
				this.jobService.addAssignment(assignment);
			}
			//model.addAttribute("assignment")
			//model.addAttribute("persons",this.personService.listPersons()) ;
			//model.addAttribute("jobs",this.jobService.listJobs());
		return "jobAssignment";
	}
}
