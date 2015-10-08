package domain1;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "common_id_gen", sequenceName = "common_seq")
    private int id;
    
	@Column(length = 50, nullable = false)
    private String name;
	
	@Column
	private int level;
    
	@ManyToMany
	@JoinTable
	private Set<Lecture> lectures;
	
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Professor mentor;
	
	public Student() {
		// TODO Auto-generated constructor stub
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

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	public Professor getMentor() {
		return mentor;
	}

	public void setMentor(Professor mentor) {
		this.mentor = mentor;
	}
	
	
}
