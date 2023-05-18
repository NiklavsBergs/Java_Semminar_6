package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@ToString
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
	
	@OneToOne
	@JoinColumn(name = "Idp")
	private Professor professor;

	public Course(
			@Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters") @NotNull String title,
			@Min(1) @Max(20) int creditPoints, Professor professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}

	
	
	
}
