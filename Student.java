import java.util.*;
import java.io.*;

public class Student {
  
  int studentID; 
  String name;
  double score; 
  String grade;
  
  
    void setStudentID (int studentID) {
      this.studentID = studentID;
    }
    int getStudentID(){
      return studentID;
    }
    
      void setName (String name) {
      this.name = name;
    }
    String getName(){
      return name;
    }
    
      void setScore (double score) {
      this.score = score;
    }
    double getScore(){
      return score;
    }
    
    String getGrade(){
      
      if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
    
    public String toString() {
      return "Student ID: " + studentID + "\nName " + name + "\nScore: " + score;
    }
    
   
     
    
}

