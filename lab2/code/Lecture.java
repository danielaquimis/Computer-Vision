import java.util.*;
public class Lecture {
    private String group;
    private int TimeSlot;
    private int type;
    private Classroom classroom;
    private Course course;

    public Lecture(String g, int s, int t){
        group = g;
        TimeSlot = s;
        type = t;
        
    }

    public void addClassroom(Classroom c){
        classroom = c;
    }

    public void addCourse(Course c){
        course = c;
    }

    public String toString(){
        return group;
    }

    public Course getCourse() {
        return course;
    }

    public int getTimeSlot(){
        return TimeSlot;
    }

    public Classroom getClassroom(){
        return classroom;
    }
}
