import java.util.ArrayList;

public class Print {
    public static void printCourses(ArrayList<Courses> courses) {
        System.out.println("*** Courses ***");
        System.out.println("No.  Code/Lecture");
        if (courses.size() == 0)
            System.out.println("--");
        else
            for (int i =0; i < courses.size(); i++)
            System.out.println((i+1) +" " +courses.get(i).toString());
    }

    public static void printStudent(ArrayList<Student> students) {
        System.out.println("*** Students ***");
        System.out.println("No. ID  Name    Courser");
        if (students.size() == 0)
            System.out.println("--");
        else
            for (int i =0; i < students.size(); i++)
            System.out.println((i+1) +" " +students.get(i).toString());
    }
}
