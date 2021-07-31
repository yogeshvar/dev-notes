public class CombiningSlimes {
    public static int maxMascots(int[] a) {
        int product = 0;
        for (int i = 0; i + 1 < a.length; i++) {
            product = product + a[i] * a[i + 1];
            a[i] = a[i + 1] = a[i] + a[i + 1];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] a = { 3, 4 };
        System.out.println("Result : " + maxMascots(a));
    }
}
