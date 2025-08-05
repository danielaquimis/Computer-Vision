import java.util.*;

public class Enrollment {
    private String seminarGroup;
    private Student student;
    private Course course;
    
    public Enrollment(String semgroup){
        seminarGroup = semgroup;
    }
    
    public void addStudent(Student s){
        student = s;
    }

    public void addCourse(Course c){
        course = c;
    }

    public Course getCourse(){
        return course;
    }
    public Student getStudent(){
        return student;
    }

}
