package domain1;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "common_id_gen", sequenceName = "common_seq")
    private int id;
    
	@Column(length = 50, nullable = false)
    private String name;
    
	@OneToMany
	private Set<Lecture> lectures;
	
	public Professor() {
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
	

}
