class NamingConventionChallenge {
    public String toCamelCase(String variableName) {
        char[] ch = variableName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '_') {
                ch[i + 1] = Character.toUpperCase(ch[i + 1]);
            }
        }
        String result = new String(ch);
        return result.replace("_", "");
    }
}

public class NamingConvention {
    public static void main(String[] args) {
        NamingConventionChallenge namingConventionChallenge = new NamingConventionChallenge();
        System.out.println(
                "Result : " + namingConventionChallenge.toCamelCase("sum_of_two_numbers"));
    }
}
