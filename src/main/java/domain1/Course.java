package domain1;

import java.util.List;
import java.util.Map;

public class Course {

    private int id;
    
    private String name;
    
    private Map<Lecture, List<Student>> lectures;
}
