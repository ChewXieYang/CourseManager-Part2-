import java.io.*;
import java.util.*;

public class Course implements Serializable{ //Copy and paste it to Course.java
    public String id;
    public String name;
    public int credits;
    private List<Course> prerequisites;
    public int minCreditsTaken;

    public Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
        this.minCreditsTaken = 0;
    }

    public Course(String id, String name, List<Course> prerequisites) {
        this.id = id;
        this.name = name;
        this.prerequisites = prerequisites;
    }

    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }

    public void setMinCreditsTaken(int minCredits) {
        this.minCreditsTaken = minCredits;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = new ArrayList<>(prerequisites);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public int getMinCreditsTaken() {
        return minCreditsTaken;
    }

    @Override
    public String toString() {
        StringBuilder courseString = new StringBuilder("CourseID: " + id + ", CourseName: " + name + ", Credits: " + credits);
        if (!prerequisites.isEmpty()) {
            courseString.append(", Prerequisites: ");
            for (Course prereq : prerequisites) {
                courseString.append(prereq.getName()).append(", ");
            }
            courseString.delete(courseString.length() - 2, courseString.length()); // Remove trailing comma
        }
        courseString.append(", MinCreditsTaken: ").append(minCreditsTaken);

        return courseString.toString();
    }

}

class CourseFile{
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

