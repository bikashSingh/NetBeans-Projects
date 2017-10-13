package Basics;
import java.util.Scanner;

public class MultiplicationTable {
  private int n,i;
  public void setNum(int n)
  {
      this.n=n;
  }

  public void displayTable()
  {
      for(i=1;i<=12;i++)
      {
          System.out.println(n+" * "+i+" = "+(n*i));
      }
  
  }
  public static void main(String[] args)
  {
    MultiplicationTable multiplicationTable=new MultiplicationTable();
    Scanner inputStream = new Scanner(System.in);
    System.out.println("Enter a number : ");
    multiplicationTable.setNum(inputStream.nextInt());
    multiplicationTable.displayTable();
    
  }
}
