public class TapMeasure {
    public static String[] draw(int leftMark, int rightMark) {
        String[] result = new String[5];
        for (int i = 0; i < 3000; i++)
            result[0] += "#";
        for (int i = 0; i < 3000; i += 2)
            result[1] += "# ";
        for (int i = 0; i < 3000; i += 5)
            result[2] += "#     ";
        for (int i = 0; i < 3000; i += 10) {
            result[3] += "#          ";
            String numberString = "" + i;
            for (int k = numberString.length(); k < 20; k++)
                numberString += " ";
            result[4] += numberString;
        }
        String[] r = new String[5];
        for (int i = 0; i < result.length; i++) {
            r[i] = result[i].substring(leftMark * 2 + 4, rightMark * 2 + 1);
        }

        return r;
    }

    public static void main(String[] args) {
        String[] result = draw(981, 990);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
    }
}
