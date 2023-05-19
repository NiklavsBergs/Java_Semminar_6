package lv.venta.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {

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
	
	@GetMapping(value="/showAllCourses")
	public String getAllCourses(){
		
		return"courses-page";
	}
}
