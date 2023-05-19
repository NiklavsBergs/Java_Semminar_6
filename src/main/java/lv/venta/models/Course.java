package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
	
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idc;
	
	@Column(name = "Title")
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters")
	@NotNull
	private String title;
	
	@Column(name = "Credit_Points")
	@Min(1)
	@Max(20)
	private int creditPoints;
	
	@OneToMany(mappedBy="course")
	@ToString.Exclude
    private Collection<Grade> grades;
	
	
	@ManyToMany
	@JoinTable(
	  name = "prof_course_table", 
	  joinColumns = @JoinColumn(name = "idc"), 
	  inverseJoinColumns = @JoinColumn(name = "idp"))
	private Collection<Professor> professors = new ArrayList<>();

	
	
	public Course(
			@Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters") @NotNull String title,
			@Min(1) @Max(20) int creditPoints, ArrayList<Professor> professors) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professors = professors;
	}
	
	public void addProfessor(Professor professor){
		if(!professors.contains(professor)) {
			professors.add(professor);
		}
	}

	public void removeProfessor(Professor professor){
		if(professors.contains(professor)) {
			professors.remove(professor);
		}
	}
	
	
}
