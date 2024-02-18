import java.io.*;
import java.util.*;

public class Courses {
    private int Credit;
    private String Code;
    private String PreReq;
    private List<Courses> prerequisites;

    // Constructor, getters, setters
    public Courses(int Credit, String Code, String PreReq){
        this.Credit = Credit;
        this.Code = Code;
        this.PreReq = PreReq;
        this.prerequisites = new ArrayList<>();
    }
    public int getCredit(){
        return Credit;
    }
    public String getCode(){
        return Code;
    }
    public String getPreReq(){
        return PreReq;
    }
    public List<Courses> getPrerequisites() {
        return prerequisites;
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
}

class Course implements Serializable{ //Copy and paste it to Course.java
    public String id;
    public String name;
    private List<Course> prerequisites;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.prerequisites = new ArrayList<>();
    }

    public Course(String id, String name, List<Course> prerequisites) {
        this.id = id;
        this.name = name;
        this.prerequisites = prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
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

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

}

}

