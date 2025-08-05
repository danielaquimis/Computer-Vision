import java.util.*;

public class Classroom {
    private String code;
    private LinkedList<Lecture> lectures;

    public Classroom(String code){
        this.code = code;
        lectures = new LinkedList<Lecture>();
    }

    public void addLecture(Lecture l){
        lectures.add(l);
    }

    public String toString(){
        return "" + code;
    }

    public LinkedList<Course> getCourses(){
        LinkedList<Course> coursesofclassroom = new LinkedList<Course>();
        for(Lecture lect: lectures){
            //to not repeat courses, if lect.getcourse not in coursesclassromm: add it
            if(!coursesofclassroom.contains(lect.getCourse())){
                coursesofclassroom.add(lect.getCourse());
            }  
        }
        return coursesofclassroom;
    }
}
