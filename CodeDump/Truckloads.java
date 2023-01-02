public class Truckloads {
    static int n = 0;

    public static int numTrucks(int numCrates, int loadSize) {
        if (numCrates > loadSize) {
            if (numCrates % 2 == 0) {
                numTrucks(numCrates / 2, loadSize);
                numTrucks(numCrates / 2, loadSize);
            } else {
                numTrucks((numCrates + 1) / 2, loadSize);
                numTrucks(numCrates / 2, loadSize);
            }
        } else {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(numTrucks(1025, 5));
    }
}
