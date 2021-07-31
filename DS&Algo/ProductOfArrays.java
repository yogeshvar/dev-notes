
public class ProductOfArrays {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int result = productOfArrays(arr, arr.length);
        System.out.println(result);
    }

    public static int productOfArrays(int a[], int length) {
        if (length == 0) {
            return 1;
        } else {
            return (productOfArrays(a, length - 1) * a[length - 1]);
        }
    }
}
