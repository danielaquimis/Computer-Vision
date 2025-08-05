import java.util.*;

public class TestUniversity{
    public static void main(String[] args){

        University2 university = new University2();
        
        System.out.println( university.getStudents() );
        System.out.println("------------------");
        System.out.println(university.getClassrooms());
        System.out.println("------------------");
        System.out.println(university.getCourses());
        System.out.println("------------------");
        System.out.println(university.getTeachers());
        
        System.out.println(university.coursesOfStudent("Harry Potter"));
        System.out.println(university.coursesofTeacher("Severus Snape")); 
        System.out.println(university.coursesofClassroom("10.101"));
        System.out.println(university.teachersofCourse("Transformations"));
        System.out.println(university.studentsofTeacher("Albus Dumbledore"));
    }
}


