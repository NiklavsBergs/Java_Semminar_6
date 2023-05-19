package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Course;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;

public interface IFilteringService {
	ArrayList<Student> retrieveAllStudents();
	ArrayList<Professor> retrieveAllProfessors();
	ArrayList<Course> retrieveAllCourse();
	ArrayList<Grade> retrieveAllGrades();
	
	ArrayList<Grade> retrieveGradesByStudentId(long id);
	ArrayList<Course> retrieveCoursesByStudent(Student student);
	ArrayList<Course> retrieveCoursesByProfessor(Professor professor);
	float AVGGradeInCourse(Course course);
}
