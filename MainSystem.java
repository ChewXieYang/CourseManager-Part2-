// Part Done
// -Admin can create students and lecturers.
// -Admin can create courses and assign courses to lecturers. 
// -Users can login and the system can recognize their user type.
// -Students can self-register for courses in new trimesters. 
// -Admin can view all the students and lecturers for courses.
// -Lecturer can view all the student in their courses. // PARTIALLY
// Maximum and minimum credits per trimester.
// Pre-requisite for CS214 & CS224.
// Pre-requisite for CS316. // PARTIALLY
// Students can view their past subjects, current subjects, and future subjects.  // PARTIALLY ?

import java.util.ArrayList;
import java.util.Scanner;


public class MainSystem {
    //
}

class TestSystem {

    public static void main(String[] args) {

        ArrayList<Course> CourseList = new ArrayList<>();
        ArrayList<Student> StudentList = new ArrayList<>();
        ArrayList<Lecturer> LecturerList = new ArrayList<>();
        ArrayList<StudentInCourse> StudentInCourse = new ArrayList<>();
        ArrayList<LecturerSubset> subLecturerList = new ArrayList<>();
        ArrayList<StudentSubset> subStudentList = new ArrayList<>();

        

        int option;
        int credits;
        int profile = 0;
        String course;
        String id;
        String LecID;
        String CourID;
        String StuID;
        String name;
        String reqID;
        String verifyPreReq1;
        String verifyPreReq2;
        String verifyPreReq3;
        String prereqQuest;
        String coursePreReq;
        String confirmation;
        boolean exitProgram = false;

        final int MIN_CREDITS_PER_TRIMESTER = 3;
        final int MAX_CREDITS_PER_TRIMESTER = 12;

        Scanner sc = new Scanner(System.in);

        StudentList.add(new Student("1211101453", "Lee",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        subStudentList.add(new StudentSubset("1211101453", "Lee"));
        StudentList.add(new Student("1211101452", "Teo",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        subStudentList.add(new StudentSubset("1211101452", "Teo"));
        LecturerList.add(new Lecturer("905488", "Steven",new ArrayList<>()));
        subLecturerList.add(new LecturerSubset("905488","Steven"));
        CourseList.add(new Course("C102","OOPDS",3, null));
        CourseList.add(new Course("C103", "Database",2 , null));
        CourseList.add(new Course("C112", "Calculus",3 , "C102"));
        CourseList.add(new Course("C113", "Programming",3 , "C103"));

        StudentInCourse.add(new StudentInCourse("C102","OOPDS", new ArrayList<>(), new ArrayList<>()));
        StudentInCourse.add(new StudentInCourse("C103","Database", new ArrayList<>(), new ArrayList<>()));
        StudentInCourse.add(new StudentInCourse("C112","Calculus", new ArrayList<>(), new ArrayList<>()));
        StudentInCourse.add(new StudentInCourse("C113","Programming", new ArrayList<>(), new ArrayList<>()));

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
                                            credits = sc.nextInt();

                                            
                                            sc.nextLine(); // consume
                                            System.out.print("Pre-req require? (Y/N): ");
                                            prereqQuest = sc.nextLine();

                                            if (prereqQuest.equalsIgnoreCase("Y"))
                                            {   
                                                System.out.print("Enter Pre-req ID: ");
                                                reqID = sc.nextLine();
                                                CourseList.add(new Course(CourID, name, credits, reqID));
                                                StudentInCourse.add(new StudentInCourse(CourID,name,new ArrayList<>(),new ArrayList<>()));
                                                System.out.println("Successfully added " + CourID + " " + name + " " + "Credits: " + credits + " PreReq: " + reqID);
                                                for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                                }
                                            }
                                            else{
                                                CourseList.add(new Course(CourID, name, credits, null));
                                                StudentInCourse.add(new StudentInCourse(CourID,name,new ArrayList<>(),new ArrayList<>()));
                                                System.out.println("Successfully added " + CourID + " " + name + " " + "Credits: " + credits);
                                                for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                                }
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
                                System.out.println("1.View Enrolled Courses");
                                System.out.println("2.Enroll Courses");
                                System.out.println("3.Drop Courses");
                                System.out.println("4.Logout");
                                System.out.print("Enter your choice (1/2/3/4): ");
                                option = sc.nextInt();
                                sc.nextLine();

                                switch (option) {
                                    case 1:
                                        int Sindex = searchStudentIdIndex(StudentList,SID);
                                        System.out.println("These are the courses you have enrolled for each Trimester");
                                        System.out.println(StudentList.get(Sindex));
                                        break;
                                    case 2:
                                        System.out.println("Select trimester you want to enroll");
                                        System.out.println("1. Trimester I: ");
                                        System.out.println("2. Trimester II: ");
                                        System.out.println("3. Trimester III: ");
                                        System.out.println("4. Back");
                                        System.out.print("Enter your choice (1/2/3/4): ");
                                        //boolean exitEnrollMenu = false;
                                        option = sc.nextInt();
                                        sc.nextLine(); // consume the newline
                                                             
                                        switch(option){
                                            case 1:
                                                int currentCredits = 0; 
                                                do{
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourse.get(Cindex);
                                                
                                                int courseCredit = Course.getCredits();


                                                coursePreReq = Course.getPreReqID();
                                                //verifyPreReq1 = Student.getPreReqIDInTrimester(CourID, Student.Trimester1); // trimester 1 dont need check pre-req since its the start of the trimester
                                                
                                                if (currentCredits + courseCredit < MIN_CREDITS_PER_TRIMESTER ){
                                                    if (coursePreReq == null){
                                                        Student.addCoursesToT1(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                        System.out.println("Credit hour not enough, please enroll more courses");
                                                    }
                                                    else if (coursePreReq != null){
                                                        System.out.println("Pre-req not satisfied");
                                                    }
                                                }
                                                else if(currentCredits + courseCredit <= MAX_CREDITS_PER_TRIMESTER ){
                                                    if (coursePreReq == null){
                                                        Student.addCoursesToT1(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                    }
                                                    else if (coursePreReq != null){
                                                        System.out.println("Pre-req " + coursePreReq + " not satisfied");
                                                    }
                                                }
                                                else if (currentCredits + courseCredit > MAX_CREDITS_PER_TRIMESTER){
                                                    System.out.println("Credit hour exceeded for Trimerster 1");
                                                }
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                }while(confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 2:
                                                currentCredits = 0; 
                                                do{
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourse.get(Cindex);

                                                int courseCredit = Course.getCredits();

                                                coursePreReq = Course.getPreReqID();
                                                verifyPreReq1 = Student.getPreReqIDInTrimester(coursePreReq, Student.Trimester1); // Trimester2 , we check the prereq for trimster 1 only.
                                                
                                                if (currentCredits + courseCredit < MIN_CREDITS_PER_TRIMESTER ){
                                                    if (coursePreReq == null){
                                                        Student.addCoursesToT2(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                        System.out.println("Credit hour not enough, please enroll more courses");
                                                    }
                                                    else if (coursePreReq.equals(verifyPreReq1)){
                                                        Student.addCoursesToT2(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                        System.out.println("Credit hour not enough, please enroll more courses");
                                                    }
                                                    else if (!coursePreReq.equals(verifyPreReq1)){
                                                        System.out.println("Pre-req " + coursePreReq + " not satisfied");
                                                    }
                                                    
                                                }
                                                else if(currentCredits + courseCredit <= MAX_CREDITS_PER_TRIMESTER ){
                                                    if (coursePreReq == null){
                                                        Student.addCoursesToT2(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                    }
                                                    else if (coursePreReq.equals(verifyPreReq1)){
                                                        Student.addCoursesToT2(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                    }
                                                    else if (!coursePreReq.equals(verifyPreReq1)){
                                                        System.out.println("Pre-req " + coursePreReq + " not satisfied");
                                                    }
                                                }
                                                else if (currentCredits + courseCredit > MAX_CREDITS_PER_TRIMESTER){
                                                    System.out.println("Credit hour exceeded for Trimerster 2");
                                                }
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                }while(confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 3:
                                                currentCredits = 0; 
                                                do{
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                StudentSubset StuSub = subStudentList.get(Sindex);
                                                StudentInCourse siCourse = StudentInCourse.get(Cindex);

                                                int courseCredit = Course.getCredits();

                                                coursePreReq = Course.getPreReqID();
                                                verifyPreReq1 = Student.getPreReqIDInTrimester(coursePreReq, Student.Trimester1); // Trimester3, we check the prereq for both trimester 1 and 2
                                                verifyPreReq2 = Student.getPreReqIDInTrimester(coursePreReq, Student.Trimester2); // Trimester3, we check the prereq for both trimester 1 and 2

                                                if (currentCredits + courseCredit < MIN_CREDITS_PER_TRIMESTER ){
                                                    if (coursePreReq == null){ // straight away enroll
                                                        Student.addCoursesToT3(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                        System.out.println("Credit hour not enough, please enroll more courses");
                                                    }
                                                    else if ( (coursePreReq.equals(verifyPreReq1)) || (coursePreReq.equals(verifyPreReq2))) // if either trimester 1 or 2 have taken pre req course
                                                    {
                                                        Student.addCoursesToT3(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                        System.out.println("Credit hour not enough, please enroll more courses");
                                                    }
                                                    else if ( !(coursePreReq.equals(verifyPreReq1)) && !(coursePreReq.equals(verifyPreReq2))){ // both doesn't taken pre req course
                                                        System.out.println("Pre-req " + coursePreReq + " not satisfied");
                                                    }
                                                }
                                                else if(currentCredits + courseCredit <= MAX_CREDITS_PER_TRIMESTER  ){
                                                    if (coursePreReq == null){
                                                        Student.addCoursesToT3(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                    }
                                                    else if ( (coursePreReq.equals(verifyPreReq1)) || (coursePreReq .equals(verifyPreReq2))) // if either trimester 1 or 2 have taken pre req course
                                                    {
                                                        Student.addCoursesToT3(Course);
                                                        siCourse.addStudent(StuSub);
                                                        System.out.println(StudentList.get(Sindex));
                                                        currentCredits += courseCredit;
                                                    }
                                                    else if ( !(coursePreReq.equals(verifyPreReq1)) && !(coursePreReq.equals(verifyPreReq2))){ // both doesn't taken pre req course
                                                        System.out.println("Pre-req " + coursePreReq + " not satisfied");
                                                    }
                                                }
                                                else if (currentCredits + courseCredit > MAX_CREDITS_PER_TRIMESTER){
                                                    System.out.println("Credit hour exceeded for this Trimerster 3");
                                                }
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
                                        System.out.print("Please key in course ID: ");
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
                                        int Lindex = searchLecturerIdIndex(LecturerList,LID);
                                        System.out.println(LecturerList.get(Lindex));
                                        break;
                                    case 2:
                                        System.out.println(StudentInCourse);
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
