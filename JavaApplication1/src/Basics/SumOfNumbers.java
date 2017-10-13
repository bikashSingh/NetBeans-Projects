package Basics;
import java.util.Scanner;

public class SumOfNumbers {
  private int n;
  private int sum;
  public SumOfNumbers()
  {
      sum=0;
  }
  public void setNum(int n)
  {
      this.n=n;
  }
  public void calculateSum()
  {
      int count;
      for(count=1;count<=n;count++)
          sum+=count;
  }
  public void displaySum()
  {
      System.out.println("Sum = "+sum);
  }
  public static void main(String[] args)
  {
    SumOfNumbers sumOfNum=new SumOfNumbers();
    Scanner inputStream = new Scanner(System.in);
    System.out.println("Enter a number : ");
    sumOfNum.setNum(inputStream.nextInt());
    sumOfNum.calculateSum();
    sumOfNum.displaySum();
    
  }
}
