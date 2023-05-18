package lv.venta.models;

import java.util.Collection;

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
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@ToString
public class Professor {
	
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;
	
	@Column(name = "Name")
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters")
	@NotNull
	private String name;
	
	@Column(name = "Surname")
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters")
	@NotNull
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	//@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	@ManyToMany
	@JoinTable(
	  name = "professor_courses", 
	  joinColumns = @JoinColumn(name = "idp"), 
	  inverseJoinColumns = @JoinColumn(name = "idc"))
	private Collection<Course> courses;

	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	public void addCourse(Course course) throws Exception {
		if(course!=null) {
			courses.add(course);
		}
		else {
			throw (new Exception("Invalid course"));
		}
	}
	
	
}
