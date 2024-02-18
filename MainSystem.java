import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class MainSystem {
    private int id;
    private String name;
    private List<Course> courses;
    private List<Student> students;
    private List<Lecturer> lecturers;
    private List<Course> existingCourses = new ArrayList<>();
    private List<Student> existingStudents = new ArrayList<>();
    private List<Lecturer> existingLecturers = new ArrayList<>();
    private List<Course> allCourses;
    private List<Student> allStudents;

    private List<Course> getPrerequisites(Course course) {
        return new ArrayList<>();
    }

    public MainSystem(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.allCourses = new ArrayList<>();
        this.allStudents = new ArrayList<>();
    }

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                System.out.println("Prerequisites of " + courseId + ": " + course.getPrerequisites());
                course.setPrerequisites(getPrerequisites(course));
                return course;
            }
        }
        return null; // Course not found
    }

    public static int searchCourseIdIndex(List<Course> courseList, String courseId) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getId().equals(courseId)) {
                return i; // Return the index when the course ID is found
            }
        }
        return -1; // Return -1 if the course ID is not found in the list
    }

    public void addCourse(String id, String name, List<Course> prerequisites) {
        /*List<Course> prerequisiteCourses = new ArrayList<>();
        String[] prerequisiteIds = prerequisites.split(",");

        for (String prerequisiteId : prerequisiteIds) {
            int index = searchCourseIdIndex(existingCourses, prerequisiteId.trim());
            if (index != -1) {
                prerequisiteCourses.add(existingCourses.get(index));
            } else {
                System.out.println("Prerequisite course with ID " + prerequisiteId + " not found.");
                // Handle the case where a prerequisite is not found (you may want to throw an exception or handle it differently)
            }
        }*/

        Course newCourse = new Course(id, name);
        newCourse.getPrerequisites().addAll(prerequisites);
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
    /*public static void main(String[] args) {
        // Example of how to use MainSystem
        MainSystem mainSystem = new MainSystem(1, "Example System");
        mainSystem.addCourse("C101", "Introduction to Programming", "Nil");
        mainSystem.addStudent("S001", "John Doe");
        mainSystem.addLecturer("L001", "Dr. Smith");
    }*/    

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public List<Lecturer> getAllLecturers() {
        return lecturers;
    }

}



class StudentSubset implements Serializable{
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

class LecturerSubset implements Serializable{
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

class StudentInCourse implements Serializable{
    String CourseID;
    String CourseName;
    public ArrayList<LecturerSubset> lecturers;
    public ArrayList<StudentSubset> students;
    
    // public void saveToFile(String filePath) {
    //     FilePersistence.writeToFile(this, filePath);
    // }

    // public static StudentInCourse loadFromFile(String filePath) {
    //     return (StudentInCourse) FilePersistence.readFromFile(filePath);
    // }

    public StudentInCourse(String CourseID, String CourseName, ArrayList<LecturerSubset> lecturers, ArrayList<StudentSubset> students) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
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

class TestSystem {

    private static final String Student_In_Course_File = "StudentInCourse.dat";

    private static final MainSystem mainSystem = new MainSystem(1, "System");
    // private static void saveStudentInCourseToFile(StudentInCourse studentInCourse) {
    //     studentInCourse.saveToFile(Student_In_Course_File);
    // }

    // private static StudentInCourse loadStudentInCourseFromFile() {
    //     return StudentInCourse.loadFromFile(Student_In_Course_File);
    // }

    private static boolean checkPrerequisitesCompleted(Student student, List<Course> prerequisites) {
        return false; // Placeholder, replace it with your actual logic
    }

    private static void enrollInTrimester(Student student, Course course, ArrayList<StudentInCourse> siCourse,
    ArrayList<StudentSubset> subStudentList, int courseIndex, int studentIndex, int trimester, Scanner sc) {
    List<Course> prerequisites = course.getPrerequisites();

        if (checkPrerequisitesCompleted(student, prerequisites)) {
            switch (trimester) {
                case 1:
                    student.addCoursesToT1(course);
                    break;
                case 2:
                    student.addCoursesToT2(course);
                    break;
                case 3:
                    student.addCoursesToT3(course);
                    break;
                default:
                    System.out.println("Invalid trimester");
            }

        StudentSubset stuSub = subStudentList.get(studentIndex);
        StudentInCourse studentInCourse = siCourse.get(courseIndex);
        studentInCourse.addStudent(stuSub); 
        System.out.println(student.toString());
        } else {
            System.out.println("You have not completed the prerequisites for this course.");
        }

        System.out.print("Do you still want to enroll (Y/N): ");
        String confirmation = sc.nextLine();
        if (!confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Enrollment canceled.");
        }
    }

    public static void main(String[] args) {

        ArrayList<Course> CourseList = new ArrayList<>();
        ArrayList<Student> StudentList = new ArrayList<>();
        ArrayList<Lecturer> LecturerList = new ArrayList<>();
        ArrayList<StudentInCourse> StudentInCourse = new ArrayList<>();
        ArrayList<LecturerSubset> subLecturerList = new ArrayList<>();
        ArrayList<StudentSubset> subStudentList = new ArrayList<>();

        StudentList.add(new Student("1211101453", "Lee",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        subStudentList.add(new StudentSubset("1211101453", "Lee"));
        LecturerList.add(new Lecturer("905488", "Steven",new ArrayList<>()));
        subLecturerList.add(new LecturerSubset("905488","Steven"));
        CourseList.add(new Course("C102","OOPDS"));
        StudentInCourse.add(new StudentInCourse("C102","OOPDS", new ArrayList<>(), new ArrayList<>()));

        Course selectedCourse = CourseList.get(0); // get the selected course
        Student selectedStudent = StudentList.get(0); // get the selected student
        int option;
        int profile = 0;
        int courseIndex = searchCourseIdIndex(CourseList, selectedCourse.getId());
        int studentIndex = searchStudentIdIndex(StudentList, selectedStudent.getId());

        String id;
        String LecID;
        String CourID;
        String StuID;
        String name;
        String confirmation;
        boolean exitProgram = false;

        Scanner sc = new Scanner(System.in);
        // StudentList.add(new Student("1211101453", "Lee",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        // subStudentList.add(new StudentSubset("1211101453", "Lee"));
        // LecturerList.add(new Lecturer("905488", "Steven",new ArrayList<>()));
        // subLecturerList.add(new LecturerSubset("905488","Steven"));
        // CourseList.add(new Course("C102","OOPDS"));
        // StudentInCourse.add(new StudentInCourse("C102","OOPDS", new ArrayList<>(), new ArrayList<>()));

        System.out.println("Welcome to Course Manager");
        do {
            System.out.println("Select your profile:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Lecturer");
            System.out.println("4. EXIT PROGRAM");
            System.out.print("Enter your choice (1/2/3/4): ");

            if (sc.hasNextInt()) {
                profile = sc.nextInt();
                sc.nextLine();

                switch (profile) {
                    case 1: // ADMIN
                        System.out.print("Please Enter Password: ");
                        String password = sc.nextLine();
                        if (password.equals("12345")) {
                            System.out.println("Welcome, Admin");
                            boolean exitAdminMenu = false;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.Add Courses");
                                System.out.println("2.Add Student");
                                System.out.println("3.Add Lecturer");
                                System.out.println("4.Assign Course");
                                System.out.println("5.Summary View");
                                System.out.println("6.Logout");
                                System.out.print("Enter your choice (1/2/3/4/5/6): ");
                                option = sc.nextInt();
                                sc.nextLine(); // Consume the newline
                                switch (option) {
                                    case 1:
                                        do {
                                            System.out.print("Please Enter Course ID: ");
                                            CourID = sc.nextLine();
                                            System.out.print("Please Enter Course Name: ");
                                            name = sc.nextLine();
                                            System.out.print("Enter Prerequisite Course ID (separated by commas): ");
                                            String prerequisiteIds = sc.nextLine();
                                            List<Course> prerequisites = new ArrayList<>();
                                            CourseList.add(new Course(CourID, name));
                                            StudentInCourse.add(new StudentInCourse(CourID,name,new ArrayList<>(),new ArrayList<>()));
                                            System.out.println("Successfully added " + CourID + " " + name);
                                            for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                            }
                                            mainSystem.addCourse(CourID, name, prerequisites);
                                            for (String prerequisiteId : prerequisiteIds.split(",")) {
                                                int index = searchCourseIdIndex(CourseList, prerequisiteId.trim());
                                                if (index != -1) {
                                                    prerequisites.add(CourseList.get(index));
                                                } else {
                                                    System.out.println("Prerequisite course with ID " + prerequisiteId + " not found.");
                                                }
                                            }
                                            CourseList.add(new Course(CourID, name));

                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 2:
                                        do {
                                            System.out.print("Please Enter Student ID: ");
                                            id = sc.nextLine();
                                            System.out.print("Please Enter Student Name: ");
                                            name = sc.nextLine();
                                            mainSystem.addStudent(id, name);
                                            System.out.println(id + " " + name + " has been successfully added");
                                            StudentList.add(new Student(id, name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
                                            for (Student list : StudentList) {
                                                System.out.println(list.toString());
                                            }
                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 3:
                                        do {
                                            System.out.print("Please Enter Lecturer ID: ");
                                            LecID = sc.nextLine();
                                            System.out.print("Please Enter Lecturer Name: ");
                                            name = sc.nextLine();
                                            mainSystem.addLecturer(LecID, name);
                                            System.out.println(LecID + " " + name + " has been successfully added");
                                            LecturerList.add(new Lecturer(LecID, name,new ArrayList<>()));
                                            subLecturerList.add(new LecturerSubset(LecID,name));
                                            for (Lecturer list : LecturerList) {
                                                System.out.println(list.toString());
                                            }
                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 4:
                                        do {
                                            System.out.print("Enter CoursesID: ");
                                            CourID = sc.nextLine();
                                            System.out.print("Enter LecturerID to assign to it: ");
                                            LecID = sc.nextLine();
                                            int Cindex = searchCourseIdIndex(CourseList,CourID);
                                            int Lindex = searchLecturerIdIndex(LecturerList,LecID);
                                            Course Course = CourseList.get(Cindex);
                                            Lecturer Lecturer = LecturerList.get(Lindex);
                                            LecturerSubset LecSub = subLecturerList.get(Lindex);
                                            StudentInCourse siCourse = StudentInCourse.get(Cindex);
                                            Lecturer.addCourses(Course);
                                            siCourse.addLecturers(LecSub);
                                            System.out.println(LecturerList.get(Lindex));
                                            System.out.print("Do you still want to assign (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 5:
                                        System.out.println(StudentInCourse);
                                    break;
                                    case 6:
                                        exitAdminMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option, Please Select Again");
                                }
                            } while (!exitAdminMenu);

                        } else
                            System.out.println("Password Incorrect, Access Denied");
                        break;

                    case 2: // STUDENT                        
                        System.out.print("Please enter you Student ID: ");
                        String SID = sc.nextLine();
                        boolean foundStudent = searchStudentID(StudentList, SID);

                        if (foundStudent) {
                            System.out.println("Welcome, Student " + SID);
                            boolean exitStudentMenu = false;
                            do {
                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses");
                                System.out.println("2.Enroll Courses");
                                System.out.println("3.Drop Courses");
                                System.out.println("4.Logout");
                                System.out.print("Enter your choice (1/2/3/4): ");
                                option = sc.nextInt();
                                sc.nextLine();

                                switch (option) {
                                    case 1:
                                        System.out.println("These are the courses you have enrolled for each Trimester");
                                        System.out.println("Trimester I: ");
                                        System.out.println("Trimester II: ");
                                        System.out.println("Trimester III: ");
                                        break;
                                    case 2:
                                        System.out.println("Select trimester you want to enroll");
                                        System.out.println("1. Trimester I");
                                        System.out.println("2. Trimester II");
                                        System.out.println("3. Trimester III");
                                        System.out.println("4. Back");
                                        System.out.print("Enter your choice (1/2/3/4): ");
                                    
                                        boolean exitEnrollMenu = false;
                                        int trimesterOption = sc.nextInt();
                                        sc.nextLine(); // consume the newline
                                    
                                        switch (trimesterOption) {
                                            case 1:
                                                // Enroll in Trimester I
                                                enrollInTrimester(selectedStudent, selectedCourse,StudentInCourse, subStudentList, courseIndex, studentIndex, 1, sc);
                                                break;
                                            case 2:
                                                // Enroll in Trimester II
                                                enrollInTrimester(selectedStudent, selectedCourse, StudentInCourse, subStudentList, courseIndex, studentIndex, 2, sc);
                                                break;
                                            case 3:
                                                // Enroll in Trimester III
                                                enrollInTrimester(selectedStudent, selectedCourse, StudentInCourse, subStudentList, courseIndex, studentIndex, 3, sc);
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Invalid option, Please Select Again");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester = III");
                                        System.out.println("Please key in course ID");
                                        String courseToDrop = sc.nextLine();
                                        System.out.println("You have dropped out of course: " + courseToDrop);
                                        break;
                                    case 4:
                                        exitStudentMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } while (!exitStudentMenu);
                        } else
                            System.out.println("ID not found, You are not registered as a student");
                        break;
                    case 3: // LECTURER
                        System.out.print("Please enter you Lecturer ID: ");
                        String LID = sc.nextLine();
                        boolean foundLecturer = searchLecturerID(LecturerList, LID);
                        if (foundLecturer) {
                            System.out.println("Welcome Lecturer " + LID);
                            boolean exitLecturerMenu = false;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses Assigned");
                                System.out.println("2.View Students in Courses");
                                System.out.println("3.Logout");
                                System.out.print("Enter your choice (1/2/3/): ");
                                option = sc.nextInt();

                                sc.nextLine();

                                switch (option) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        exitLecturerMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                }

                            } while (!exitLecturerMenu);
                        } else
                            System.out.println("ID not found, You are not registered as a lecturer");
                        break;
                    case 4:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Invalid profile, Please Select Again");
                }
            } else {
                System.out.println("Please enter an integer");
                sc.nextLine(); // Consume the invalid input
            }
        } while (!exitProgram);
        // saveStudentInCourseToFile(StudentInCourse.get(0)); // Save example
        // StudentInCourse loadedData = loadStudentInCourseFromFile(); 
    }

    // To identify Student
    public static boolean searchStudentID(ArrayList<Student> StudentList, String SID) {
        for (Student StudentID : StudentList) {
            if (StudentID.getId().equals(SID))
                return true;
        }
        return false;
    }

    // To identify Lecturer
    public static boolean searchLecturerID(ArrayList<Lecturer> LecturerList, String LID) {
        for (Lecturer LecturerID : LecturerList) {
            if (LecturerID.getId().equals(LID))
                return true;
        }
        return false;
    }

    // Get CourseID index
    public static int searchCourseIdIndex(ArrayList<Course> CourseList, String CourID) {
    for (int i = 0; i < CourseList.size(); i++) {
        if (CourseList.get(i).getId().equals(CourID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the course ID is not found in the list
    }

    // Get LecturerID index
    public static int searchLecturerIdIndex(ArrayList<Lecturer> LecturerList, String LecID) {
    for (int i = 0; i < LecturerList.size(); i++) {
        if (LecturerList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the lecturer ID is not found in the list
    }

    // Get StudentID index
    public static int searchStudentIdIndex(ArrayList<Student> StudentList, String LecID) {
    for (int i = 0; i < StudentList.size(); i++) {
        if (StudentList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the student ID is not found in the list
    }
}   



