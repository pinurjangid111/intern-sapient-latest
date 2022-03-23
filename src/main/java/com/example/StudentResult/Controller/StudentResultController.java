package com.example.StudentResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.StudentResult.Domain.Admin;
import com.example.StudentResult.Domain.StudentResult;
import com.example.StudentResult.Service.AdminService;
import com.example.StudentResult.Service.StudentResultService;
 
@Controller
public class StudentResultController {
	
	 @Autowired
	  private StudentResultService service;
	 
	 @Autowired
	 private AdminService adminService;
 
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<StudentResult> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        System.out.print("Get / ");	
	        return "index";
	    }
 
	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("student", new StudentResult());
	        return "new";
	    }
 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") StudentResult std) {
	        service.save(std);
	        return "redirect:/";
	    }
 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        StudentResult std = service.get(id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/login")
	    public String view() {
	       // model.addAttribute("student", new StudentResult());
	        return "Login";
	    }
	    
	    @RequestMapping(value = "/new", method = RequestMethod.POST)
	    public String access(@ModelAttribute("admin") Admin admin) {
	       
	    	List<Admin> list = adminService.listAllAdmin();
	    	
	    	for(Admin temp: list) {
	    		if(temp.getUsername().equalsIgnoreCase(admin.getUsername()) && temp.getPassword().equalsIgnoreCase(admin.getPassword())) {
	    			return "new";
	    		}
	    			
	    	}
	   
	        return "redirect:/";
	    }
}
