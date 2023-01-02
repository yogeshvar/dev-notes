// Not Solved
public class AgeEncoding {
    public static double getRadix(int age, String candlesLine) {
        for (double base : new double[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 36 }) {
            int i = Integer.parseInt(candlesLine, (int) base);
            if (age == i) {
                return (double) base;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int age = 21;
        String candlesLine = "10101";
        System.out.println("" + getRadix(age, candlesLine));
    }
}