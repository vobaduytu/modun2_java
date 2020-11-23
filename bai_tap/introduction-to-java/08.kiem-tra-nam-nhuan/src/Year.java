import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int year;
        System.out.println("Enter Year");
        year = sc.nextInt();
        boolean isLeapYear = false;
        boolean isDivisbileBy4 = year%4==0;
        if (isDivisbileBy4){
            boolean isDivisbileBy100 = year%100==0;
            if (isDivisbileBy100){
                boolean isDivisbileBy400 = year%400==0;
                if (isDivisbileBy400){
                    isLeapYear = true;
                }
                else {
                    isLeapYear = false;
                }
            }
            if (isLeapYear){
                System.out.printf("%d is a leap year ", year);
             } else {
                System.out.printf("%d is not a leap year",year);
            }
        }
    }
}
