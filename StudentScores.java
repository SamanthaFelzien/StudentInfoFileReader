/*Program: Reads in a file, instantiates an object with values from the file and stores those objects in a linked list.
 *Methods access those objects to gather student scores and find the average score, standard deviation, relativity to average
 *and assigns a letter grade.
 * Developer: Samantha Felzien
 * Date: 1/30/17
 * Class: CIS 279
 */

import java.util.*;
import java.io.*;

public class StudentScores{
  public static void main(String [] args) {
    
    //HW1_Students file to open   
    String studentScores = "HW1_Students.txt";
    LinkedList<Student> studentInfo = new LinkedList<Student>();
    double sumScore = 0.0;
    double scoreAvg = 0.0;
    double stndDev = calcStndDev(scoreAvg, studentInfo,sumScore);
      
   //Iterate through studentScores file and instantiate object attributes 
    try {
      BufferedReader in = new BufferedReader(new FileReader(studentScores));
      String inputData;
      while ((inputData = in.readLine()) !=null){
            Student student = new Student();
            student.setStudentID(Integer.parseInt(inputData));
            student.setName(in.readLine());
            student.setScore(Double.parseDouble((in.readLine())));
           studentInfo.add(student) ;
           
           sumScore += student.getScore();
        }   
        in.close();
      }catch(FileNotFoundException fnf){
        fnf.printStackTrace();
      }//file not found
      catch (Exception e) {
        e.printStackTrace();
        System.out.println("\nProgram terminated Safely...");
      }//exception e
      
//Find score average
    scoreAvg = sumScore/(studentInfo.size());

      System.out.print("AVERAGE SCORE: " + scoreAvg );
      //Print and call method to calculate standard deviation
      System.out.format("     STANDARD DEVIATION: " + calcStndDev(scoreAvg, studentInfo, sumScore));
      System.out.println(); 
      System.out.println(); 
      System.out.println("NAME                     SCORE       RELATIVE TO     GRADE");
      System.out.println("                                      AVERAGE                 ");
      System.out.println(); 
      //Loop through objects in the linked list and print each objects attributes
      for(Student student: studentInfo)
      {
        System.out.format("%-25s%5s%16s%10s", student.getName(), student.getScore(), relAvg(student.getScore(), scoreAvg),student.getGrade());
       System.out.println();
        /*System.out.print(student.getName());
        System.out.print("    " + student.getScore());
        System.out.print(relAvg(student.getScore(), scoreAvg));
        System.out.print(student.getGrade());
        System.out.println(); */
      }     
    }
  //Calculate standard deviation
public static double calcStndDev (double scoreAvg, LinkedList<Student> studentInfo, double sumScore)
    {
      double stndDev = 0.0;
      double f = 0.0;
      for(Student student: studentInfo)
      {
       double p =(student.getScore()-scoreAvg);
       double pow = Math.pow(p, 2);
       f += pow; 
      }
       double s = (studentInfo.size()-1);
       double g = f/s;
       stndDev = Math.sqrt(g);
      return stndDev;
    }
    
//Find relativity to the average score
    public static String relAvg (double score, double scoreAvg)
    {
      if (score > scoreAvg)
      {
        return " > average";
      } else if (score == scoreAvg){
        return " = average";
      } else {
         return " < average";
      } 
        
    }
    }     
