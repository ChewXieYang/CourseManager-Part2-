import java.io.*;
import java.util.*;

class Student implements Serializable{ // Can also copy and paste it to Student.java
    public String id;
    public String name;
    public ArrayList<Course> Trimester1;
    public ArrayList<Course> Trimester2;
    public ArrayList<Course> Trimester3;

    public Student(String id, String name,ArrayList<Course> Trimester1, ArrayList<Course> Trimester2, ArrayList<Course> Trimester3) {
        this.id = id;
        this.name = name;
        this.Trimester1 = Trimester1;
        this.Trimester2 = Trimester2;
        this.Trimester3 = Trimester3;
    }

    public String toString() {
        return "StudentID: " + id + ", StudentName: " + name + ", Trimester1: " + Trimester1 + ", Trimester2: " + Trimester2  + ", Trimester3: " + Trimester3;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean contains(String SID) {
        return false;
    }

    public void addCoursesToT1(Course course){
        Trimester1.add(course);
    }
    public void addCoursesToT2(Course course){
        Trimester2.add(course);
    }
    public void addCoursesToT3(Course course){
        Trimester3.add(course);
    }

    public boolean hasCompleted(Course course) {
        // Implement your logic to check if the student has completed the course
        // For simplicity, assume the student has completed the course if it's in Trimester1
        return Trimester1.contains(course);
    }
}

class StudentFile{
    public static void main(String[] args){
    String CourseFile = "Courses.csv";

    try{
    Scanner scanner = new Scanner(new File(CourseFile));
    LinkedList<String[]> CourseData = new LinkedList<>();

    while(scanner.hasNextLine()){
        String[] line = scanner.nextLine().split(",");
        CourseData.add(line);
    }

    for (String[] row: CourseData){
        for(String value : row){
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    scanner.close();
    } catch(FileNotFoundException e){
        e.printStackTrace();
    }
}
}

