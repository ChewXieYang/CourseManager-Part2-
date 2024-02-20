import java.io.Serializable;
import java.util.ArrayList;

class Lecturer implements Serializable{ //Can also copy and paste it to Lecturer.java
    public String id;
    public String name;
    public ArrayList<Course> courses;

    public Lecturer(String id, String name, ArrayList<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }
   
    public String toString() {
        return "LecturerID: " + id + ", LecturerName: " + name + " , CoursesAssigned: " + courses;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean contains(String LID) {
        return false;
    }

    public void addCourses(Course course){
        courses.add(course);
    }
}


class LecturerSubset{
    public String id;
    public String name;

    public LecturerSubset(String id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public String toString() {
        return "Lecturer: " + id + "_" + name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}