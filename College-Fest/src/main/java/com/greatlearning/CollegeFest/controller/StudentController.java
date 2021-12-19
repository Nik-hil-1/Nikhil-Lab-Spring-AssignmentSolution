
package com.greatlearning.CollegeFest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.CollegeFest.entities.Student;
import com.greatlearning.CollegeFest.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		
		return "student-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		model.addAttribute("Student", student);
		
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showformForUpdate(@RequestParam("id") long id, Model model) {
		
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") long id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		
		Student student;
		
		if(id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		else {
			
			student = new Student(name, department, country);
		}
		
		studentService.save(student);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") long id, Model model) {
		
		studentService.deleteById(id);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.addObject("msg", "Hi " + user.getName() + " you do not have permission to access this page!");
		}
		else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		
		model.setViewName("403");
		return model;
	}
}
