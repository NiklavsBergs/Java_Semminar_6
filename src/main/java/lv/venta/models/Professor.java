package lv.venta.models;

import java.util.Collection;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Professor extends Person{
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	//@OneToOne(mappedBy = "professor")
	@ManyToMany(mappedBy = "professors")
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();

	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		this.degree = degree;
	}
	
	public void addCourse(Course course){
		if(!courses.contains(course)) {
			courses.add(course);
		}
	}
	
	public void removeCourse(Course course){
		if(courses.contains(course)) {
			courses.remove(course);
		}
	}
	
	
}
