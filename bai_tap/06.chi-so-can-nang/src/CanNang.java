import java.util.Scanner;

public class CanNang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width, height, bmi;
        System.out.println("You Width (kg)");
        width = sc.nextDouble();
        System.out.println("you height (meter)");
        height = sc.nextDouble();
        bmi = width / Math.pow(height, 2);
        System.out.println(bmi + "interpretation\n");
        if (bmi < 18)
            System.out.println(bmi+ "Underweight");
         else if (bmi<25.0)
            System.out.println(bmi + "normal");
         else if (bmi<30.0)
            System.out.println(bmi +"overweight");
         else
            System.out.println(bmi + "obese");
    }
}
