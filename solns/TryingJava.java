public class TryingJava {

    public static void main(String[] args) {
        int ones = 2, zeros = 2;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < ones; i++)
            stringBuilder.append("1");
        for (int i = 0; i < zeros; i++)
            stringBuilder.append("0");
        System.out.println("" + stringBuilder.toString());

    }
}
