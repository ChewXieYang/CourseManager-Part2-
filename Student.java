import java.io.*;
import java.util.*;



class Student implements Serializable{ 
    public String id;
    public String name;
    public String PreReqID;
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


    public void dropCoursesT1(Course course){
        Trimester1.remove(course);
    }
    public void dropCoursesT2(Course course){
        Trimester2.remove(course);
    }
    public void dropCoursesT3(Course course){
        Trimester3.remove(course);
    }



    public String getPreReqIDInTrimester(String courseId, ArrayList<Course> trimester) {
        for (Course c : trimester) {
            if (c.getId().equals(courseId)) {
                return c.getId();
            }
        }
        return null; // Course not found in the trimester or prerequisite ID not available
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


class StudentSubset{
    public String id;
    public String name;

    public StudentSubset(String id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public String toString() {
        return "Student: " + id + "_" + name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class StudentInCourse{
    String CourseID;
    String CourseName;
    public ArrayList<LecturerSubset> lecturers;
    public ArrayList<StudentSubset> students;

    public StudentInCourse(String CourseID,String CourseName, ArrayList<LecturerSubset> lecturers ,ArrayList<StudentSubset> students){
        
        this.CourseID =CourseID;
        this.CourseName =CourseName;
        this.lecturers = lecturers;
        this.students = students;
    }

    public String toString() {
        return "Course: " + CourseID +"_"+ CourseName + lecturers + students;
    }

    
    public void addStudent(StudentSubset student){
        students.add(student);
    }

    public void addLecturers(LecturerSubset LecSub) {
        lecturers.add(LecSub);
    }
    
   
}
    
