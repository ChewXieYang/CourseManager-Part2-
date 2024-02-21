import java.io.*;
import java.util.*;


class Course { 
    public String id;
    public String name;
    public int credits;
    public String PreReqID;
    

    public Course(String id, String name , int credits , String PreReqID) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.PreReqID = PreReqID;
    }

    public String toString() {
        return "CourseID: " + id + ", CourseName: " + name;
    }
    
    // public String toString2(){
    //     return "CourseID: " + id + ", CourseName: " + name;
    // }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCredits(){
        return credits;
    }

    public String getPreReqID(){
        return PreReqID;
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




