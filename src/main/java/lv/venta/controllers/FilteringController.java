package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			return"all-grades-page";
		}
		catch(Exception e){
			model.addAttribute("packetError", "Wrong ID");
			return "error-page";
		}
	}
	
	
	@GetMapping(value="/showAllCoursesByProfessor/{id}")
	public String getCoursesByProfessor(@PathVariable("id") long id, Model model){
		try {
			model.addAttribute("courses", filterService.retrieveCoursesByProfessorId(id));
			return"all-courses-page";
		}
		catch(Exception e){
			model.addAttribute("msg", "Wrong ID");
			return "error-page";
		}
	}
	
	@GetMapping(value="/showAllCoursesByStudent")
	public String getCoursesByStudent(@RequestParam(name = "id") long id, Model model){
		try {
			model.addAttribute("courses", filterService.retrieveCoursesByStudentId(id));
			return"all-courses-page";
		}
		catch(Exception e){
			model.addAttribute("msg", "Wrong ID");
			return "error-page";
		}
	}
	
	@GetMapping(value="/AVGgradeInCourse/{id}")
	public String getAVGGradeInCourse(@PathVariable("id") long id, Model model){
		try {
			model.addAttribute("avggrade", filterService.calculateAVGGradeInCourseId(id));
			return"AVG-grade-page";
		}
		catch(Exception e){
			model.addAttribute("msg", "Wrong ID");
			return "error-page";
		}
	}
}
