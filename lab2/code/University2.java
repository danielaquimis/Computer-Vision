import java.util.*;

public class University2 {
    private LinkedList <Student> studentslist;
    private LinkedList <Teacher> teacherslist;
    private LinkedList <Classroom> classroomslist;
    private LinkedList <Course> courseslist;
    private LinkedList <Enrollment> enrollmentslist;
    private LinkedList <Assignment> assignmentslist;
    private LinkedList <Lecture> lectureslist;

    public University2(){
        
        studentslist = new LinkedList<Student>();
        teacherslist = new LinkedList<Teacher>(); 
        classroomslist = new LinkedList<Classroom>();
        courseslist = new LinkedList<Course>();
        enrollmentslist = new LinkedList<Enrollment>();
        assignmentslist = new LinkedList<Assignment>();
        lectureslist = new LinkedList<Lecture>();

        LinkedList< String[] > students = Utility.readXML( "student" );
        LinkedList< String[] > teachers = Utility.readXML( "teacher" );
        LinkedList< String[] > classrooms = Utility.readXML( "classroom" );
        LinkedList< String[] > courses = Utility.readXML( "course" );

        for(String[] array : students){
            Student studentATT = new Student(array[0], array[1]);
            studentslist.add(studentATT);
        }
        
        for( String[] array : teachers){
            Teacher teacherATT = new Teacher(array[0]);
            teacherslist.add(teacherATT);
        }

        for(String[] array : classrooms){
            
            Classroom classroomATT = new Classroom(array[0]);
            classroomslist.add(classroomATT);
        }

        for(String[] array : courses){
            Course courseATT = new Course(array[0]);
            courseslist.add(courseATT);
        }
        
        LinkedList< String[] > lectures = Utility.readXML( "lecture" );
        LinkedList< String[] > enrollments = Utility.readXML( "enrollment" );
        LinkedList< String[] > assignments = Utility.readXML( "assignment" );

        for(String[] array : lectures){
            int type = Integer.parseInt(array[3]);
            int TimeSlot = Integer.parseInt(array[2]);
            Lecture lectureATT = new Lecture(array[4],TimeSlot, type);
            
            Classroom classroomAA = Utility.getObject(array[0],classroomslist);
            Course course = Utility.getObject(array[1], courseslist);
            lectureATT.addCourse(course);
            lectureATT.addClassroom(classroomAA);
           
            classroomAA.addLecture(lectureATT);
            course.addLecture(lectureATT);
        }

        for(String[] array: enrollments){
            Enrollment enrollmentATT = new Enrollment(array[2]);
            enrollmentslist.add(enrollmentATT);
            
            Student student = Utility.getObject( array[0], studentslist );
            Course course = Utility.getObject( array[1], courseslist );
            enrollmentATT.addStudent(student);
            enrollmentATT.addCourse(course);

            student.addEnrollment( enrollmentATT );
            course.addEnrollment( enrollmentATT );
        }

        for(String[] array: assignments){
            LinkedList<String> groups = new LinkedList<String>();
            int idx = 0;
            int len = array.length;
            while(idx < len){
                if (idx >= 2 ){
                    String group = array[idx];
                    groups.add(group);
                }
                idx++;
            }
            Assignment assignmentATT = new Assignment(groups);
            assignmentslist.add(assignmentATT);

            Teacher teacher = Utility.getObject(array[0], teacherslist);
            Course course = Utility.getObject( array[1], courseslist );
            assignmentATT.addCourse(course);
            assignmentATT.addTeacher(teacher);

            teacher.AddAssignment(assignmentATT);
            course.AddAssignment(assignmentATT);
        }
    }


    public LinkedList< String > getStudents(){
        return Utility.toString(studentslist);
    }
    public LinkedList< String> getTeachers(){
        return Utility.toString(teacherslist);
    }
    public LinkedList< String> getClassrooms(){
        return Utility.toString(classroomslist);
    }
    public LinkedList< String> getCourses(){
        return Utility.toString(courseslist);
    }

    public LinkedList<Course> coursesOfStudent(String student){
        //obtain courses of a student   LinkedList<String>
        Student studentAA = Utility.getObject(student, studentslist);
        return studentAA.getCourses();

    }
    
    public LinkedList<Course> coursesofTeacher(String teacher){
        
        Teacher teacherAA = Utility.getObject(teacher, teacherslist);
        return teacherAA.getCourses();
    }

    public LinkedList<Course> coursesofClassroom(String classroom){
        
        Classroom classroomAA = Utility.getObject(classroom, classroomslist);
        return classroomAA.getCourses();
    }

    public LinkedList<Teacher> teachersofCourse(String course){

        Course courseAA = Utility.getObject(course, courseslist);
        return courseAA.getTeahcers();
    }

    public LinkedList<Student> studentsofTeacher(String teacher){

        Teacher teacherAA = Utility.getObject(teacher, teacherslist);
        return teacherAA.getStudents();
    }


}
