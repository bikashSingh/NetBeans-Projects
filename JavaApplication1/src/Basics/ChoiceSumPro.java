package Basics;
import java.util.Scanner;

public class ChoiceSumPro {
  private int n;
  private int sum,prod;
  public ChoiceSumPro()
  {
      sum=0;
      prod=1;
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
  public void calculateProduct()
  {
      int count;
      for(count=1;count<=n;count++)
          prod*=count;
  }
  public void displaySum()
  {
      System.out.println("Sum = "+sum);
  }
    public void displayProduct()
  {
      System.out.println("Product = "+prod);
  }
  public static void main(String[] args)
  {
    ChoiceSumPro choiceSumPro=new ChoiceSumPro();
    Scanner inputStream = new Scanner(System.in);
    System.out.println("Enter a number : ");
    choiceSumPro.setNum(inputStream.nextInt());
    System.out.println("Enter 1 for sum and Enter 2 for product : ");
    int choice = inputStream.nextInt();
    switch(choice)
    {
        case 1 : choiceSumPro.calculateSum();
                 choiceSumPro.displaySum();
                 break;
        case 2 : choiceSumPro.calculateProduct();
                 choiceSumPro.displayProduct();
                 break;
        default : System.out.println("Wrong choice!");
    } 
  }
}
