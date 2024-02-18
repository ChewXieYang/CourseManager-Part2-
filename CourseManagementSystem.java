// // import java.util.*;
// import java.util.ArrayList;
// import java.util.Scanner;

// public class CourseManagementSystem {
//     private int id;
//     private String name;
//     private String prerequisite;

//     public CourseManagementSystem(int id, String name) {
//         this.id = id;
//         this.name = name;
//         this.prerequisite = prerequisite;
//     }

// }

// private static String getPrerequisite(String courseID, ArrayList<String> courseList) {
//     for (String courseDetails : courseList) {
//         String[] courseInfo = courseDetails.split(" ");
//         if (courseInfo[0].equals(courseID) && courseInfo.length > 2) {
//             return courseInfo[2];
//         }
//     }
//     return "";
// }

// class TestSystem {
//     public static void main(String[] args) {

//         ArrayList<String> CourseList = new ArrayList<>();
//         ArrayList<String> StudentList = new ArrayList<>();
//         ArrayList<String> LecturerList = new ArrayList<>();
//         ArrayList<String> CourseTrimesterI = new ArrayList<>();
//         ArrayList<String> CourseTrimesterII = new ArrayList<>();
//         ArrayList<String> CourseTrimesterIII = new ArrayList<>();
//         ArrayList<String> StudentCoListA = new ArrayList<>();
//         ArrayList<String> StudentCoListB = new ArrayList<>();
//         ArrayList<String> LeTeachList = new ArrayList<>();

//         int profile = 0;
//         String course;
//         int option;
//         String student;
//         String lecturer;
//         String courseID1;
//         String courseID2;
//         String courseID3;
//         boolean exitProgram = false;
//         Scanner sc = new Scanner(System.in);

//         StudentList.add("1211101453 Lee");
//         LecturerList.add("905477 Steven");
//         CourseList.add("CS101 Toolbox Theory"); // course A
//         CourseList.add("TCP2201 Programming"); // course B
//         LeTeachList.add("CS101 Toolbox Theory");

//         System.out.println("Welcome to Course Manager");
//         do {
//             System.out.println("Select your profile:");
//             System.out.println("1. Admin");
//             System.out.println("2. Student");
//             System.out.println("3. Lecturer");
//             System.out.println("4. EXIT PROGRAM");
//             System.out.print("Enter your choice (1/2/3/4): ");

//             if (sc.hasNextInt()) {
//                 profile = sc.nextInt();
//                 sc.nextLine();

//                 switch (profile) {
//                     case 1: // ADMIN
//                         System.out.print("Please Enter Password: ");
//                         String password = sc.nextLine();
//                         if (password.equals("12345")) {
//                             System.out.println("Welcome, Admin");
//                             boolean exitAdminMenu = false;
//                             String confirmation;
//                             do {
//                                 System.out.println("Select OPTION");
//                                 System.out.println("1.Add Courses");
//                                 System.out.println("2.Add Student");
//                                 System.out.println("3.Add Lecturer");
//                                 System.out.println("4.Assign Courses");
//                                 System.out.println("5.Logout");
//                                 System.out.print("Enter your choice (1/2/3/4/5): ");
//                                 option = sc.nextInt();
//                                 sc.nextLine(); // Consume the newline

//                                 switch (option) {
//                                     case 1:
//                                         do {
//                                             System.out.println("Please Enter Course ID and Name ");
//                                             course = sc.nextLine();
//                                             String[] courseInfo = courseDetails.split(" ");
        
//                                             String courseID = courseInfo[0];
//                                             String courseName = courseInfo[1];
//                                             String prerequisite = courseInfo.length > 2 ? courseInfo[2] : "";
                                    
//                                             CourseList.add(courseDetails);
//                                             System.out.println(course + " has been successfully added");
//                                             System.out.println("Do you still want to add (yes/no)");
//                                             confirmation = sc.nextLine();
//                                         } while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 2:
//                                         do {
//                                             System.out.println("Please Enter Student ID and Name ");
//                                             student = sc.nextLine();
//                                             StudentList.add(student);
//                                             System.out.println(student + " has been successfully added");
//                                             System.out.println("Do you still want to add (yes/no)");
//                                             confirmation = sc.nextLine();
//                                         } while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 3:
//                                         do {
//                                             System.out.println("Please Enter Lecturer ID and Name ");
//                                             lecturer = sc.nextLine();
//                                             LecturerList.add(lecturer);
//                                             System.out.println(lecturer + " has been successfully added");
//                                             System.out.println("Do you still want to add (yes/no)");
//                                             confirmation = sc.nextLine();
//                                         } while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 4:
//                                         do {
//                                             // ASSIGN COURSES TO LECTURER
//                                             System.out.println("Please Enter Course ID and Name ");
//                                             course = sc.nextLine();
//                                             System.out.println("Please Enter Lecturer ID and Name ");
//                                             lecturer = sc.nextLine();

//                                             System.out.println(course + " has successfully been assigned to " + lecturer);
//                                             System.out.println("Do you still want to assign (yes/no)");
//                                             confirmation = sc.nextLine();
//                                             System.out.println("Do you still want to assign (yes/no)");
//                                             confirmation = sc.nextLine();
//                                         } while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 5:
//                                         exitAdminMenu = true;
//                                         break;
//                                     default:
//                                         System.out.println("Invalid option, Please Select Again");
//                                 }
//                             } while (!exitAdminMenu);

//                         } else
//                             System.out.println("Password Incorrect, Access Denied");
//                         break;

//                     case 2: // STUDENT

//                         System.out.print("Please enter you Student ID: ");
//                         String SID = sc.nextLine();
//                         boolean foundStudent = searchStudentID(StudentList, SID);
                        
//                         if (foundStudent) {
//                             System.out.println("Welcome, Student " + SID);
//                             boolean exitStudentMenu = false;
//                             String confirmation;
//                             do {
//                                 System.out.println("Select OPTION");
//                                 System.out.println("1.View Courses");
//                                 System.out.println("2.Enroll Courses");
//                                 System.out.println("3.Drop Courses");
//                                 System.out.println("4.Logout");
//                                 System.out.print("Enter your choice (1/2/3/4): ");
//                                 option = sc.nextInt();
//                                 sc.nextLine();
//                                 switch (option) {
//                                     case 1://VIEW ENROLLED COURSES
//                                         System.out.println("These are the courses you have enrolled for each Trimester");
//                                         System.out.println("Trimester I: " + CourseTrimesterI);
//                                         System.out.println("Trimester II: "+ CourseTrimesterII);
//                                         System.out.println("Trimester III: "+ CourseTrimesterIII);
//                                         break;

//                                     case 2://ENROLL COURSE
//                                         do{
//                                         System.out.println("Select your trimester");
//                                         System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
//                                         int trimester = sc.nextInt();
//                                         sc.nextLine();
//                                         System.out.println("Please key in course ID");
//                                         String courseID = sc.nextLine();
//                                         String prerequisite = getPrerequisite(courseID, CourseList);
//                                         if (!prerequisite.isEmpty() && !StudentCoListA.contains(prerequisite)) {
//                                             System.out.println("You need to complete the prerequisite course (" + prerequisite + ") first.");
//                                             break;
//                                         }                                           
//                                             switch(trimester){
//                                                 case 1:
//                                                     courseID1 = sc.nextLine();
//                                                     CourseTrimesterI.add(courseID1);
//                                                     if (courseID1 == "CS101") 
//                                                         StudentCoListA.add(SID);
//                                                     else
//                                                         StudentCoListB.add(SID);
//                                                     System.out.println("You have enrolled for course: " + courseID1 + " in Trimester " + trimester);
//                                                     break;
//                                                 case 2:
//                                                     courseID2 = sc.nextLine();
//                                                     CourseTrimesterII.add(courseID2);
//                                                     if (courseID2 == "CS101") 
//                                                         StudentCoListA.add(SID);
//                                                     else
//                                                         StudentCoListB.add(SID);
//                                                     System.out.println("You have enrolled for course: " + courseID2 + " in Trimester " + trimester);
//                                                     break;
//                                                 case 3:
//                                                     courseID3 = sc.nextLine();
//                                                     CourseTrimesterIII.add(courseID3);
//                                                     if (courseID3 == "CS101") 
//                                                         StudentCoListA.add(SID);
//                                                     else
//                                                         StudentCoListB.add(SID);
//                                                     System.out.println("You have enrolled for course: " + courseID3 + " in Trimester " + trimester);
//                                                     break;
//                                             }
//                                         System.out.println("Would you like to enroll more courses? (yes/no)");
//                                         confirmation = sc.nextLine();
//                                         }while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 3://DROPOUT COURSE
//                                         do{
//                                         System.out.println("Select your trimester");
//                                         System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
//                                         int trimester = sc.nextInt();
//                                         sc.nextLine();
//                                         System.out.println("Please key in course ID");
//                                         switch(trimester){
//                                                 case 1:
//                                                     courseID1 = sc.nextLine();
//                                                     CourseTrimesterI.remove(courseID1);
//                                                     if (courseID1 == "CS101") 
//                                                         StudentCoListA.remove(SID);
//                                                     else
//                                                         StudentCoListB.remove(SID);
//                                                     System.out.println("You have dropped course: " + courseID1 + " in Trimester " + trimester);
//                                                     break;
//                                                 case 2:
//                                                     courseID2 = sc.nextLine();
//                                                     CourseTrimesterII.remove(courseID2);
//                                                     if (courseID2 == "CS101") 
//                                                         StudentCoListA.remove(SID);
//                                                     else
//                                                         StudentCoListB.remove(SID);
//                                                     System.out.println("You have dropped course: " + courseID2 + " in Trimester " + trimester);
//                                                     break;
//                                                 case 3:
//                                                     courseID3 = sc.nextLine();
//                                                     CourseTrimesterIII.remove(courseID3);
//                                                     if (courseID3 == "CS101") 
//                                                         StudentCoListA.remove(SID);
//                                                     else
//                                                         StudentCoListB.remove(SID);
//                                                     System.out.println("You have dropped course: " + courseID3 + " in Trimester " + trimester);
//                                                     break;
//                                             }
//                                         System.out.println("Would you like to drop more courses? (yes/no)");
//                                         confirmation = sc.nextLine();
//                                         }while (confirmation.equalsIgnoreCase("yes"));
//                                         break;
//                                     case 4:
//                                         exitStudentMenu = true;
//                                         break;
//                                     default:
//                                         System.out.println("Invalid option");
//                                     }
//                                 } while (!exitStudentMenu);
//                             } else
//                             System.out.println("ID not found, You are not registered as a student");
//                         break;

//                     case 3: // LECTURER
//                         System.out.print("Please enter you Lecturer ID: ");
//                         String LID = sc.nextLine();
//                         boolean foundLecturer = searchLecturerID(LecturerList, LID);
//                         if (foundLecturer) {
//                             System.out.println("Welcome Lecturer " + LID);
//                             boolean exitLecturerMenu = false;
//                             do {

//                                 System.out.println("Select OPTION");
//                                 System.out.println("1.View Courses Assigned");
//                                 System.out.println("2.View Students in Courses");
//                                 System.out.println("3.Logout");
//                                 System.out.print("Enter your choice (1/2/3/): ");
//                                 option = sc.nextInt();

//                                 sc.nextLine();

//                                 switch (option) {
//                                     case 1: // print the course teach
//                                         System.out.println("You have assigned the following class: ");
//                                         for (int i = 0; i < LeTeachList.size(); i++) {
//                                             System.out.print(LeTeachList.get(i) +", ");
//                                         }
//                                         System.out.println("");
//                                         break;
//                                     case 2:
//                                         System.out.println("Type the course you want to check: ");
//                                         String checkCourse = sc.nextLine();
//                                         System.out.println("The students in course: ");
//                                         if (checkCourse.equals("CS101")) {  // decide course
//                                             for (int i = 0; i < StudentCoListA.size(); i++) {
//                                             System.out.println( (i+1) +".  " + StudentCoListA.get(i));
//                                             }
//                                             System.out.println("");
//                                         }
//                                         else {
//                                             for (int i = 0; i < StudentCoListB.size(); i++) {
//                                             System.out.println( (i+1) +".  " + StudentCoListB.get(i));
//                                             }
//                                             System.out.println("");
//                                         }
//                                         break;
//                                     case 3:
//                                         exitLecturerMenu = true;
//                                         break;
//                                     default:
//                                         System.out.println("Invalid option");
//                                 }

//                             } while (!exitLecturerMenu);
//                         } else
//                             System.out.println("ID not found, You are not registered as a lecturer");
//                         break;
//                     case 4:
//                         exitProgram = true;
//                         break;
//                     default:
//                         System.out.println("Invalid profile, Please Select Again");
//                         break;

//                 }
//             } else {
//                 System.out.println("Please enter an integer");
//                 sc.nextLine(); // Consume the invalid input
//             }
//         } while (!exitProgram);

//     }

//     // Method to identify Student
//     public static boolean searchStudentID(ArrayList<String> StudentList, String SID) {
//         for (String StudentID : StudentList) {
//             if (StudentID.contains(SID))
//                 return true;
//         }
//         return false;
//     }

//     // Method to identify Lecturer
//     public static boolean searchLecturerID(ArrayList<String> LecturerList, String LID) {
//         for (String LecturerID : LecturerList) {
//             if (LecturerID.contains(LID))
//                 return true;
//         }
//         return false;
//     }

// }
