package domain1;

import java.util.List;
import java.util.Map;

public class Course {

    private int id;
    
    private String name;
    
    private Map<Lecture, List<Student>> lectures;
    
    public Course() {
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

	public Map<Lecture, List<Student>> getLectures() {
		return lectures;
	}

	public void setLectures(Map<Lecture, List<Student>> lectures) {
		this.lectures = lectures;
	}
    
    
}
