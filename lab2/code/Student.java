import java.util.*;

public class Student {
    
    private String name;
    private String nia;
    private LinkedList <Enrollment> enrollment_list;    

    public Student(String name, String nia){
        this.name = name;
        this.nia = nia;
        enrollment_list = new LinkedList<Enrollment>();
    }

    public void addEnrollment(Enrollment e){
        enrollment_list.add(e);
    }

    public String toString(){
        return name;
    }

    public LinkedList<Course> getCourses(){
        
        LinkedList<Course> coursesofstudent = new LinkedList<Course>();
        for (Enrollment en: enrollment_list) {
                Course c = en.getCourse();
                coursesofstudent.add(c);
        }
        return coursesofstudent;

    }
    
}
