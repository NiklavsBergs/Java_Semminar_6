package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Course;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;

public interface IFilteringService {
	ArrayList<Student> retrieveAllStudents();
	ArrayList<Professor> retrieveAllProfessors();
	ArrayList<Course> retrieveAllCourses();
	ArrayList<Grade> retrieveAllGrades();
	
	ArrayList<Grade> retrieveGradesByStudentId(long id) throws Exception;
	ArrayList<Course> retrieveCoursesByStudentId(long id) throws Exception;
	ArrayList<Course> retrieveCoursesByProfessorId(long id) throws Exception;
	float calculateAVGGradeInCourseId(long id) throws Exception;
}
