package CodeApha_Student_Grade_Tracker.model;
import java.util.*;

public class Student {

    Scanner sc = new Scanner(System.in);

    private int Rollno ;
    private String name;
    private List<Integer> marks = new ArrayList<>();
    private char grade;
    private float average = 0.0f;
    private static int counter = 1;

    public  Student(){}

    public Student(String name , int m1 , int m2 , int m3 , int m4 , int m5)
    {
        Rollno = counter++;
        this.name = name;
        marks.add(m1);
        marks.add(m2);
        marks.add(m3);
        marks.add(m4);
        marks.add(m5);

    }

    public void setMarks()
    {
       for(int i=0 ; i<5 ; i++)
       {
         System.out.println("Enter the marks : ");
         marks.set(i, sc.nextInt());
       }

    }

    public int getMarks(int indx)
    {
        return marks.get(indx);
    }

    public int getRollno()
    {
        return Rollno;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public float getAverage()
    {
        return this.average;
    }

    public char getGrade()
    {
        return this.grade;
    }

    public void setGrade(char grade)
    {
        this.grade = grade;
    }

    public void setAverage(float average)
    {
        this.average = average;
    }



    @Override
    public String toString()
    {
        return "\n Roll no : " + this.getRollno() + "\n Name :  " + this.getName() + "\n Marks : | 1.English : " + this.marks.get(0) + " | 2.Physics : " + this.marks.get(1) 
        + " | 3.Chemistry : " + this.marks.get(2) + " | 4.Maths : " + this.marks.get(3) + " | 5.Bilogy : " + this.marks.get(4) + " | "+ "\n Average: " + this.getAverage() 
        + "\n Grade : " + this.getGrade() ;

    }

}
