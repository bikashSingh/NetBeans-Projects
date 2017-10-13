package Basics;

import java.util.Scanner;

public class GuessGame {

    private int num = 100;

    public boolean checkNum(int n) {
        return (n == num);
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame();
        Scanner inputStream = new Scanner(System.in);
        int a[] = new int[50];
        boolean f;
        int i = 1, j;
        int noOfTry = 0;
        int num;
        while (true) {
            System.out.println("Enter a number : ");
            num = inputStream.nextInt();
            if (guessGame.checkNum(num)) {
                noOfTry++;
                System.out.println("No. of try = " + noOfTry);
                break;
            } else if (num <= 50) {
                f = true;
                System.out.println("too small");
                for (j = 0; j <a.length; j++) {
                    if (num == a[j]) {
                        f = false;
                    }
                }
                if (f == true) {
                    noOfTry++;
                }
                a[i++] = num;
            } else if (num >= 150) {
                f = true;
                System.out.println("too large");
                for (j = 0; j <a.length; j++) {
                    if (num == a[j]) {
                        f = false;
                    }
                }
                if (f == true) {
                    noOfTry++;
                }
                a[i++] = num;
            } else {
                f = true;
                System.out.println("you are close.Try again.");
                for (j = 0; j <a.length; j++) {
                    if (num == a[j]) {
                        f = false;
                    }
                }
                if (f == true) {
                    noOfTry++;
                }
                a[i++] = num;
            }

        }
    }
}
