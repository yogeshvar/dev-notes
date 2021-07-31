import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlusOneGame {
    public static String getOrder(String s) {
        char cChar[] = s.toCharArray();
        int count = 0;
        ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+')
                ++count;
            else
                cardNumbers.add(s.charAt(i) - '0');
        }
        if (count == 0) {
            Arrays.sort(cChar);
            return String.valueOf(cChar);
        } else if (count == s.length()) {
            return s;
        } else {
            Collections.sort(cardNumbers);
            StringBuilder stringBuilder = new StringBuilder("");
            int counter = 0;
            for (int i = 0; i < cardNumbers.size(); i++) {
                int entry = cardNumbers.get(i);
                while (entry > counter && count > 0) {
                    stringBuilder.append("+");
                    --count;
                    counter++;
                }
                stringBuilder.append(entry);
            }
            while (count > 0) {
                stringBuilder.append("+");
                --count;
            }
            return stringBuilder.toString();
        }

    }

    public static void main(String[] args) {
        String s = "++++4++++200++2++1+6++++++";
        System.out.println("Result : " + getOrder(s));
    }
}