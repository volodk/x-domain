package domain1;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "common_id_gen", sequenceName = "common_seq")
	private int id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@OneToMany
	private List<Professor> professors;
	
	@OneToMany
	private List<Student> students;
	
	private Map<Integer, List<Student>> studentGroups;
	
	public Faculty() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
