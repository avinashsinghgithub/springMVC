package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Job;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.JobService;

@Controller
public class JobController {
	
	
	private JobService jobService;
	
	@Autowired
	@Qualifier(value="jobService")
	public void setJobService( JobService jobService){
		this.jobService=jobService;
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
}
