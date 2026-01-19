package CodeApha_Student_Grade_Tracker.app;
import java.util.Scanner;

import CodeApha_Student_Grade_Tracker.model.Student;
import CodeApha_Student_Grade_Tracker.service.Report;


public class Student_Grade_Main {
 
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        Report repo = new Report();

        do{

        System.out.println("\n------------------------ Menu ------------------------\n");
        System.out.println("\n1.Add Student");
        System.out.println("\n2.Remove Student");
        System.out.println("\n3.Display Report");
        System.out.println("\n4.Exit");

        int choice ;
        System.out.println("Enter your Coice : ");
        choice = sc.nextInt();

        switch(choice)
        {
            case 1 :
                System.out.println("Enter the name : ");
                 String name = sc.next();

                System.out.println("Enter the Marks for English : ");
                int english = sc.nextInt();
                System.out.println("Enter the Marks for Physics : ");
                int physics = sc.nextInt();
                System.out.println("Enter the Marks for Chemistry : ");
                int chemistry = sc.nextInt();
                System.out.println("Enter the Marks for Maths : ");
                int maths = sc.nextInt();
                System.out.println("Enter the Marks for Biology : ");
                int biology = sc.nextInt();
                
                repo.addStudent(new Student(name , english , physics , chemistry , maths, biology));
                break;

            case 2:
                int rno;
                System.out.println("Enter the roll no. to Remove the Student : ");
                rno = sc.nextInt();
                repo.removeStudent(rno);
                break;
                
            case 3 :
                repo.DisplayRecords();
                break;
                
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;  
                
            default:
                System.out.println("Invalid choice !");
                break;    

        }
    }while(true);
  }
}
