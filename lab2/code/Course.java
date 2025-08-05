import java.util.*;

public class Course {
    private String name;
    private LinkedList<Enrollment> enrollments;
    private LinkedList<Assignment> assignments;
    private LinkedList<Lecture> lectures;

    public Course(String name){
        this.name = name;
        enrollments = new LinkedList<Enrollment>();
        assignments = new LinkedList<Assignment>();
        lectures = new LinkedList<Lecture>();
    }

    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }

    public void AddAssignment(Assignment a){
        assignments.add(a);
    }

    public void addLecture(Lecture l){
        lectures.add(l);
    }

    public String toString(){
        return name;
    }

    public LinkedList<Teacher> getTeahcers() {
        LinkedList<Teacher> teachers = new LinkedList<Teacher>();
        for(Assignment assign: assignments){
            teachers.add(assign.getTeacher());
        }
        return teachers;
    }

    public LinkedList<Student> getStudents() {
        LinkedList<Student> students = new LinkedList<Student>();
        for(Enrollment en: enrollments){
            students.add(en.getStudent());
        }
        return students;
    }

}
