import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private int systemId;
    private String systemName;
    private List<Course> courses;
    private List<Student> students;
    private List<Lecturer> lecturers;
    private List<StudentInCourse> studentInCourseList; 

    public MainSystem(int systemId, String systemName) {
        this.systemId = systemId;
        this.systemName = systemName;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.studentInCourseList = new ArrayList<>(); 
    }

    public Course getCourseById(String courseId) {

        return null;
    }

    public void addCourse(String courseId, String courseName, Course[] prerequisites, int minCreditsPrerequisite) {
        Course newCourse = new Course(courseId, courseName, 0); // Assuming 0 credits for simplicity
        newCourse.setPrerequisites(prerequisites);
        newCourse.setMinCreditsTaken(minCreditsPrerequisite);
        courses.add(newCourse);

        StudentInCourse siCourse = new StudentInCourse(courseId, courseName, new ArrayList<>(), new ArrayList<>());
        studentInCourseList.add(siCourse);
    }
    
    public void addStudent(String studentId, String studentName) {
        Student newStudent = new Student(studentId, studentName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        students.add(newStudent);
    }

    public List<StudentInCourse> getAllStudentInCourses() {
        return studentInCourseList;
    }
    
    public void addLecturer(String lecturerId, String lecturerName) {
        Lecturer newLecturer = new Lecturer(lecturerId, lecturerName, new ArrayList<>());
        lecturers.add(newLecturer);
    }

    public List<Course> getAllCourses() {
        
        return courses;
    }

}

class Course { 
    public String id;
    public String name;
    public int credits;

    private ArrayList<Course> prerequisites;
    private int minCreditsTaken;

    public int getMinCreditsPrerequisite() {
        return minCreditsTaken;
    }
    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }
    public void setPrerequisites(Course[] prerequisites) {
        this.prerequisites = new ArrayList<>(Arrays.asList(prerequisites));
    }
    public void setMinCreditsTaken(int minCredits) {
        this.minCreditsTaken = minCredits;
    }
    public Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
    }
    public String toString() {
        return "CourseID: " + id + ", CourseName: " + name;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }   
    public int getCredits() {
        return credits;
    }
}

class Student { // Can also copy and paste it to Student.java
    public String id;
    public String name;
    public ArrayList<Course> Trimester1;
    public ArrayList<Course> Trimester2;
    public ArrayList<Course> Trimester3;

    private int trimester1Credits;
    private int trimester2Credits;
    private int trimester3Credits;
    private int totalCredits;

    public Student(String id, String name,ArrayList<Course> Trimester1, ArrayList<Course> Trimester2, ArrayList<Course> Trimester3) {
        this.id = id;
        this.name = name;
        this.Trimester1 = new ArrayList<>();
        this.Trimester2 = new ArrayList<>();
        this.Trimester3 = new ArrayList<>();
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
    private boolean checkMinimumCreditsPrerequisite(Course course, ArrayList<Course> trimesterCourses) {
        int completedCredits = 0;
    
        for (Course c : trimesterCourses) {
            completedCredits += c.getCredits();
        }
    
        return completedCredits >= course.getMinCreditsPrerequisite();
    }
    public void addCoursesToT1(Course course){
        if (checkMinimumCreditsPrerequisite(course, Trimester1)) {
            Trimester1.add(course);
            trimester1Credits += course.getCredits();
            totalCredits += course.getCredits();
        } else {
            System.out.println("Minimum credits prerequisite not met for course: " + course.getId());
        }

    }
    public void addCoursesToT2(Course course){
        if (checkMinimumCreditsPrerequisite(course, Trimester2)) {
            Trimester3.add(course);
            trimester3Credits += course.getCredits();
            totalCredits += course.getCredits();
        } else {
            System.out.println("Minimum credits prerequisite not met for course: " + course.getId());
        }
    }
    public void addCoursesToT3(Course course){
        if (checkMinimumCreditsPrerequisite(course, Trimester3)) {
            Trimester3.add(course);
        } else {
            System.out.println("Minimum credits prerequisite not met for course: " + course.getId());
        }
    }
    public int getTrimester1Credits() {
        int trimester1Credits = 0;
        for (Course course : Trimester1) {
            trimester1Credits += course.getCredits();
        }
        return trimester1Credits;
    }
    public int getTrimester2Credits() {
        int trimester1Credits = 0;
        for (Course course : Trimester1) {
            trimester1Credits += course.getCredits();
        }
        return trimester1Credits;
    }
    public int getTrimester3Credits() {
        int trimester1Credits = 0;
        for (Course course : Trimester1) {
            trimester1Credits += course.getCredits();
        }
        return trimester1Credits;
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

class Lecturer { //Can also copy and paste it to Lecturer.java
    public String id;
    public String name;
    public ArrayList<Course> courses;

    public Lecturer(String id, String name, ArrayList<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
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

class StudentInCourse{
    String CourseID;
    String CourseName;
    public ArrayList<LecturerSubset> lecturers;
    public ArrayList<StudentSubset> students;

    public StudentInCourse(String CourseID,String CourseName, ArrayList<LecturerSubset> lecturers ,ArrayList<StudentSubset> students){
        
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.lecturers = lecturers != null ? lecturers : new ArrayList<>();
        this.students = students != null ? students : new ArrayList<>();;
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
    public static void main(String[] args) {

        ArrayList<Course> CourseList = new ArrayList<>();
        ArrayList<Student> StudentList = new ArrayList<>();
        ArrayList<Lecturer> LecturerList = new ArrayList<>();
        ArrayList<StudentInCourse> StudentInCourseList = new ArrayList<>();
        ArrayList<LecturerSubset> subLecturerList = new ArrayList<>();
        ArrayList<StudentSubset> subStudentList = new ArrayList<>();

        int option;
        int profile = 0;
        String course;
        String id;
        String LecID;
        String CourID;
        String StuID;
        String name;
        String confirmation;
        boolean exitProgram = false;

        final int MIN_CREDITS_PER_TRIMESTER = 3;
        final int MAX_CREDITS_PER_TRIMESTER = 12;

        Scanner sc = new Scanner(System.in);

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
                                            System.out.print("Please Enter Course Credits: ");
                                            int credits = sc.nextInt();
                                            sc.nextLine();

                                            Course newCourse = new Course(CourID, name, credits);

                                            System.out.print("Does the course have prerequisites? (Y/N): ");
                                            confirmation = sc.nextLine();
                                            if (confirmation.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter the number of prerequisites: ");
                                                int numPrerequisites = sc.nextInt();
                                                sc.nextLine(); // Consume the newline
                                    
                                                for (int i = 0; i < numPrerequisites; i++) {
                                                    System.out.print("Enter prerequisite course ID: ");
                                                    String prereqID = sc.nextLine();
                                    
                                                    // Find and add the prerequisite course
                                                    int prereqIndex = searchCourseIdIndex(CourseList, prereqID);
                                                    if (prereqIndex != -1) {
                                                        newCourse.addPrerequisite(CourseList.get(prereqIndex));
                                                    } else {
                                                        System.out.println("Prerequisite course not found. Please add the prerequisite course first.");
                                                    }
                                                }
                                            }

                                            System.out.print("Enter the minimum credits prerequisite: ");
                                            int minCreditsPrerequisite = sc.nextInt();
                                            sc.nextLine();
                                            newCourse.setMinCreditsTaken(minCreditsPrerequisite);

                                            CourseList.add(newCourse);
                                            System.out.println("Successfully added " + newCourse.toString());
                                            
                                            for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                            }

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
                                            System.out.println(id + " " + name + " has been successfully added");
                                            StudentList.add(new Student(id, name, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
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
                                            System.out.println(LecID + " " + name + " has been successfully added");
                                            LecturerList.add(new Lecturer(LecID, name, new ArrayList<>()));
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
                                            System.out.print("Enter Course ID: ");
                                            CourID = sc.nextLine();
                                            System.out.print("Enter Lecturer ID to assign to it: ");
                                            LecID = sc.nextLine();
                                            int Cindex = searchCourseIdIndex(CourseList, CourID);
                                            int Lindex = searchLecturerIdIndex(LecturerList, LecID); 
                                            Course currentCourse = CourseList.get(Cindex);
                                            Lecturer currentLecturer = LecturerList.get(Lindex);
                                            LecturerSubset lecSub = subLecturerList.get(Lindex);
                                            StudentInCourse siCourse = StudentInCourseList.get(Cindex);
                                            currentLecturer.addCourses(currentCourse);
                                            siCourse.addLecturers(lecSub);
                                            System.out.println(LecturerList.get(Lindex));
                                            System.out.print("Do you still want to assign (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 5:
                                        System.out.println(StudentInCourseList);
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
                                        System.out.println("1. Trimester I: ");
                                        System.out.println("2. Trimester II: ");
                                        System.out.println("3. Trimester III: ");
                                        System.out.println("4. Back");
                                        System.out.print("Enter your choice (1/2/3/4): ");

                                        option = sc.nextInt();
                                        sc.nextLine(); // consume the newline
                                                             
                                        switch(option){
                                            case 1:
                                                do{
                                                System.out.print("Enter Course ID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                if (Cindex != -1) {
                                                    Course currentCourse = CourseList.get(Cindex);
                                                    int credits = currentCourse.getCredits(); 
                                                } else {
                                                    System.out.println("Course not found. Please enter a valid Course ID.");
                                                }
                                                    int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course currentCourse = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                int credits = currentCourse.getCredits();
                                                int currentTrimesterCredits = Student.getTrimester1Credits();

                                                if (currentTrimesterCredits + credits > MAX_CREDITS_PER_TRIMESTER) {
                                                    System.out.println("Enrollment exceeds maximum credits allowed for Trimester I.");
                                                    break;
                                                }

                                                if (currentTrimesterCredits + credits < MIN_CREDITS_PER_TRIMESTER) {
                                                    System.out.println("Enrollment falls below minimum credits required for Trimester I.");
                                                    break;
                                                }

                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourseList.get(Cindex);
                                                Student.addCoursesToT1(currentCourse);
                                                siCourse.addStudent(StuSub);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                
                                                }while(confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 2:
                                                do{
                                                System.out.print("Enter Course ID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourseList.get(Cindex);
                                                Student.addCoursesToT2(Course);
                                                siCourse.addStudent(StuSub);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                }while(confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 3:
                                                do{
                                                System.out.print("Enter Course ID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourseList.get(Cindex);
                                                Student.addCoursesToT3(Course);
                                                siCourse.addStudent(StuSub);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                } while (confirmation.equalsIgnoreCase("Y"));
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
                                        course = sc.nextLine();
                                        System.out.println("You have dropped out of course: " + course);
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
                                    //System.out.println(LecturerList.get(L));
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
    return -1;
    }
    // Get LecturerID index
    public static int searchLecturerIdIndex(ArrayList<Lecturer> LecturerList, String LecID) {
    for (int i = 0; i < LecturerList.size(); i++) {
        if (LecturerList.get(i).getId().equals(LecID)) {
            return i;
        }
    }
    return -1;
    }
    // Get StudentID index
    public static int searchStudentIdIndex(ArrayList<Student> StudentList, String LecID) {
    for (int i = 0; i < StudentList.size(); i++) {
        if (StudentList.get(i).getId().equals(LecID)) {
            return i;
        }
    }
    return -1;
    }
}  



