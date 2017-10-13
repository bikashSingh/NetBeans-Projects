package Basics;
import java.util.Scanner;

public class SumOfNumbersMul {
  private int n,i;
  private int sum;
  public SumOfNumbersMul()
  {
      sum=0;
  }
  public void setNum(int n)
  {
      this.n=n;
  }
  public void calculateSum()
  {
      for(i=1;i<=n;i++)
            {
                   if((i%3==0) || (i%5==0))
                   {
                       sum=sum+i;
                   }
            }
  }
  public void displaySum()
  {
      System.out.println("Sum = "+sum);
  }
  public static void main(String[] args)
  {
    SumOfNumbersMul sumOfNumMul=new SumOfNumbersMul();
    Scanner inputStream = new Scanner(System.in);
    System.out.println("Enter a number : ");
    sumOfNumMul.setNum(inputStream.nextInt());
    sumOfNumMul.calculateSum();
    sumOfNumMul.displaySum();
    
  }
}
