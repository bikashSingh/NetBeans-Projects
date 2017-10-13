package Basics;
import java.util.Scanner;

public class PrimeNumbers {
  private int n,i,j;
  private boolean f;
  public void setNum(int n)
  {
      this.n=n;
  }

  public void displayPrime()
  {
      
      for(i=1;i<=n;i++)
      {
          f = true;
         
          for(j=2;j<=i/2;j++)
          {
              if(i%j==0)
                  f=false;
          }
          if(f==true)
              System.out.println(i);
         
      }
  
  }
  public static void main(String[] args)
  {
    PrimeNumbers primeNumbers=new PrimeNumbers();
    Scanner inputStream = new Scanner(System.in);
    System.out.println("Enter a number : ");
    int n=inputStream.nextInt();
    primeNumbers.setNum(n);
    System.out.println("Prime numbers upto "+n+"are ");
    primeNumbers.displayPrime();
    
  }
}
