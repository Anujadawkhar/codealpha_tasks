package CodeApha_Student_Grade_Tracker.service;
import java.util.*;

import javax.sound.sampled.SourceDataLine;

import CodeApha_Student_Grade_Tracker.model.Student;


public class Report {
    private List<Student> details = new ArrayList<>();

    public Report()
    {

    }

    public static void CalculateGrade(Student stud)
    {
        float avg = 0.0f;
        int sum = 0;

        for(int i=0 ; i<5 ; i++)
        {
            sum = sum + stud.getMarks(i);
        }

        avg = (sum / 5.0f);

        stud.setAverage(avg);

        if(avg >= 90.0)
        {
            stud.setGrade('A');
        }
        else if(avg < 90.0 && avg >= 80.0)
        {
            stud.setGrade('B');
        }
        else if(avg < 80.0 && avg >= 70.0)
        {
            stud.setGrade('C');
        }
        else if(avg < 70.0 && avg >= 60.0)
        {
            stud.setGrade('D');
        }
        else{
            stud.setGrade('F');
        }
        
    }

    public void addStudent(Student stud)
    {
        CalculateGrade(stud);
        details.add(stud);

    }

    public void removeStudent(int rno)
    {
        for(Student i : details)
        {
            if(i.getRollno() == rno)
            {
                details.remove(rno-1);
                System.out.println("Student of Roll no " + rno + " Removed Successfully!");
                break;
            }
        }
    }


    public void DisplayRecords()
    {
        for(Student i : details)
        {
            int high = i.getMarks(0);
            int low = i.getMarks(0);
           
           System.out.println(i.toString());
           
           for(int j=0 ; j<5 ; j++)
           {
              if(high < i.getMarks(j))
              {
                high = i.getMarks(j);
              }

              if(low > i.getMarks(j))
              {
                low = i.getMarks(j);
              }
             
           }

            System.out.println("Student Highest marks : " + high);
            System.out.println("Student Lowest marks : " + low);
        }
    }

}
