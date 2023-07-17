package Arrays.ArrayProjects;

import java.util.*;

public class AverageTemperatures {
    public static void main(String[] args) {
        System.out.println("How many days' temperatures?");
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        double[] temps = new double[days];
        int sum = 0;
        for (int i = 0; i < days; i++) {
            System.out.println("Day " + (i + 1) + "'s high temp: ");
            temps[i] = sc.nextDouble();
            sum += temps[i];
        }
        sc.close();
        double average = (double) sum / days;
        System.out.println("Average = " + average);
        int count = 0;
        for (int i = 0; i < days; i++) {
            if (temps[i] > average) {
                count++;
            }
        }
        System.out.println(count + " days were above average.");
    }
}
