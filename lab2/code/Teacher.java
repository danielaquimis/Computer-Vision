import java.util.*;
public class Teacher {
    private String name;
    private LinkedList <Assignment> assignments;

    public Teacher(String name){
        this.name = name;
        assignments = new LinkedList<Assignment>();        
    }
    public void AddAssignment(Assignment a){
        assignments.add(a);
    }

    public String toString(){
        return name;
    }

    public  LinkedList<Course> getCourses(){
        LinkedList<Course> courses = new LinkedList<Course>();
        for(Assignment temp: assignments){
            courses.add(temp.getCourse());
        }
        return courses;
    }
    public LinkedList<Student> getStudents() {
        LinkedList <Student> students = new LinkedList<Student>();
        for(Assignment assign: assignments){
            Course c = assign.getCourse();
            LinkedList <Student> studentsAUX = c.getStudents();
            //copying the values from students of course to students final linkedlist
            for(Student s: studentsAUX){
                if(!students.contains(s)){ // to not repeat in the students list
                    students.add(s);
                }
            }
        }
        return students;
    }


}
