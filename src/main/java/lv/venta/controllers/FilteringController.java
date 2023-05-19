package lv.venta.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class FilteringController {

	@GetMapping(value="/showAllStudents")
	public String getAllStudents(){
		
		return"students-page";
	}
	
	@GetMapping(value="/showAllProfessors")
	public String getAllProfessors(){
		
		return"professors-page";
	}
	
	@GetMapping(value="/showAllCourses")
	public String getAllCourses(){
		
		return"courses-page";
	}
	
	@GetMapping(value="/showAllGrades")
	public String getAllGrades(){
		
		return"grades-page";
	}
	
	@GetMapping(value="/showAllGradesByStudent")
	public String getGradesByStudent(){
		
		return"grades-page";
	}
	@PostMapping(value="/showAllGradesByStudent")
	public String postGradesByStudent(){
		
		return"grades-page";
	}
}
