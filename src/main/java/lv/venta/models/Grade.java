package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "grade_table")
@Entity
@Getter
@Setter
@ToString
public class Grade {

	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idg;
	
	@Column(name = "gvalue")
	@Min(0)
	@Max(10)
	private int gvalue;
	
	@ManyToOne
    @JoinColumn(name="idst")
    private Student student;
	
	@ManyToOne
	@JoinColumn(name="idc")
	private Course course;

	public Grade(@Min(0) @Max(10) int value) {
		this.gvalue = value;
	}
	
	
}
