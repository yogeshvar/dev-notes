package udemyCourse;

class Powers {
    public static void main(String[] args) {
        int result = powers(2, 4);
        System.out.println(result);
    }

    public static int powers(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * powers(base, exp - 1);
    }

}
