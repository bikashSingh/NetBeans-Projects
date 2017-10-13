package Basics;

public class LeapYears {
    
  static boolean checkYear(int year)
  {
       return (((year%4==0) && (year%100!=0)) || (year%400==0));
  }
  public void displayLeapYears()
  {
      int i= 1;
      int year = 2017;
      while(i<=20)
      {
          if(checkYear(year))
          {
              System.out.println(year);
              i++;
          }
        year++;
        
      }
      
  }
  public static void main(String[] args)
  {
    LeapYears leapYears=new LeapYears();
    leapYears.displayLeapYears();
  }
}
