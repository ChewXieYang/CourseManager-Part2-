import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    private int id;
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Course> existingCourses = new ArrayList<>();
    private ArrayList<Student> existingStudents = new ArrayList<>();
    private ArrayList<Lecturer> existingLecturers = new ArrayList<>();
    private ArrayList<Course> allCourses;
    private ArrayList<Student> allStudents;

    private List<Course> getPrerequisites(Course course) {
        return new ArrayList<>();
    }

    public MainGUI(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.allCourses = new ArrayList<>();
        this.allStudents = new ArrayList<>();
    }
    public List<Course> getAllCourses() {
        return allCourses;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public List<Lecturer> getAllLecturers() {
        return lecturers;
    }



    public void addCourse(String id, String name, int credits , String PreReqID) {

        Course newCourse = new Course(id, name, credits, PreReqID);
        //newCourse.getPreReqID().addAll(prerequisites);
        courses.add(newCourse);
        existingCourses.add(newCourse);
        System.out.println("Course added: " + newCourse);
    }

    public void addStudent(String id, String name) {
        Student newStudent = new Student(id, name, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        students.add(newStudent);
        existingStudents.add(newStudent);
        System.out.println("Student added: " + newStudent);
    }

    public void addLecturer(String id, String name) {
        Lecturer newLecturer = new Lecturer(id, name, new ArrayList<>());
        lecturers.add(newLecturer);
        existingLecturers.add(newLecturer);
        System.out.println("Lecturer added: " + newLecturer);
    }
    

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                System.out.println("Prerequisites of " + courseId + ": " + course.getPreReqID());
                course.setPrerequisites(getPrerequisites(course));
                return course;
            }
        }
        return null; // Course not found
    }
}

