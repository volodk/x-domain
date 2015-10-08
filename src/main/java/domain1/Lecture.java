package domain1;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_lecture")
public class Lecture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "common_id_gen", sequenceName = "common_seq")
    private int id;
    
	@Column(length = 50, nullable = false)
    private String name;
    
    @ManyToOne
	private Professor professor;
	
    @ManyToMany
	private Set<Student> students;
	
	public Lecture() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
