package com.scp.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.scp.java.bean.EmpBean;
import com.scp.java.serivce.EmpService;

@Controller
public class EmployeeController {

		private EmpService empService;
		
		@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
		public String listPersons(Model model) {
			model.addAttribute("emplist", empService.getallEmp());
			
			System.out.println(empService.getallEmp());
			
			model.addAttribute("employee", new EmpBean());
			
			return "index";
		}
		
		//For add and update person both
		@RequestMapping(value= "/emp/add", method = RequestMethod.POST)
		public String addPerson(@ModelAttribute("employee") EmpBean bean){
			if(bean.geteId() == 0)
				empService.AddEmp(bean);
			else
				empService.updateEmp(bean);
			return "redirect:/home";
		}
		
		@RequestMapping("/scp/remove/{id}")
	    public String removePerson(@PathVariable("id") int id){
			empService.deleteEmp(id);
	        return "redirect:/home";
	    }
	 
	    @RequestMapping("/scp/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	    	EmpBean toBeUpdated = empService.getEmp(id);
	    	model.addAttribute("employee", toBeUpdated);
	    	model.addAttribute("emplist", empService.getallEmp());
	        return "index";
	    }
	}

