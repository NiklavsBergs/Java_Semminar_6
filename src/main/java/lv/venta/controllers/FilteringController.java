package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.services.IFilteringService;
import lv.venta.services.Impl.FilteringServiceImpl;

@Controller
public class FilteringController {
	
	@Autowired
	private IFilteringService filterService;
	
	@GetMapping(value="/showAllStudents")
	public String getAllStudentsFunc(Model model){
		model.addAttribute("students", filterService.retrieveAllStudents());
		return"all-students-page";
	}
	
	@GetMapping(value="/showAllProfessors")
	public String getAllProfessors(Model model){
		model.addAttribute("professors", filterService.retrieveAllProfessors());
		return"all-professors-page";
	}
	
	@GetMapping(value="/showAllCourses")
	public String getAllCourses(Model model){
		model.addAttribute("courses", filterService.retrieveAllCourses());
		return"all-courses-page";
	}
	
	@GetMapping(value="/showAllGrades")
	public String getAllGrades(Model model){
		model.addAttribute("grades", filterService.retrieveAllGrades());
		return"all-grades-page";
	}
	
	@GetMapping(value="/showAllGradesByStudent/{id}")
	public String getGradesByStudent(@PathVariable("id") long id, Model model){
		try {
			model.addAttribute("grades", filterService.retrieveGradesByStudentId(id));
			return"grades-by-student-page";
		}
		catch(Exception e){
			model.addAttribute("packetError", "Wrong ID");
			return "error-page";
		}
	}
	@PostMapping(value="/showAllGradesByStudent")
	public String postGradesByStudent(){
		
		return"grades-by-page";
	}
	
	@GetMapping(value="/showAllCoursesByStudent")
	public String getCoursesByStudent(){
		
		return"courses-by-page";
	}
	@PostMapping(value="/showAllCoursesByStudent")
	public String postCoursesByStudent(){
		
		return"courses-by-page";
	}
}
