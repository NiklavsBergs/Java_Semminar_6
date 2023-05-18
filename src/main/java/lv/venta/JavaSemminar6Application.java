package lv.venta;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class JavaSemminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSemminar6Application.class, args);
	}

	@Bean
	public CommandLineRunner testModel(IProfessorRepo prRepo, IStudentRepo stRepo, ICourseRepo coRepo, IGradeRepo grRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor p1 = new Professor("Juris", "Zagars", Degree.phd);
				Professor p2 = new Professor("Dimitrijs", "Smirnovs", Degree.phd);
				prRepo.save(p1);
				prRepo.save(p2);
				
				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Baiba", "Kalnina");
				stRepo.save(s1);
				stRepo.save(s2);
				
				Course c1 = new Course("Haosa teorija", 4, (Collection<Professor>) p1);
				Course c2 = new Course("Matematika", 2, (Collection<Professor>) p1);
				Course c3 = new Course("Ekonomika", 2, (Collection<Professor>) p2);
				Course c4 = new Course("Ekonomika2", 2, (Collection<Professor>) p2);
				coRepo.save(c1);
				coRepo.save(c2);
				coRepo.save(c3);
				coRepo.save(c4);
			
				grRepo.save(new Grade(5, s1, c1));
				grRepo.save(new Grade(7, s1, c2));
				grRepo.save(new Grade(10, s2, c1));
				grRepo.save(new Grade(8, s2, c2));
				
			}
		};
	}
	
}
