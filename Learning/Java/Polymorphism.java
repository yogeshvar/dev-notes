class Multiple {
    static int multiply(int a, int b) {
        return a * b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }
}

class Operate {
    void operate(int a, int b) {
        System.out.println("Operation will be done for" + a + "and" + b);
    }
}

class Addition extends Operate {
    void operate(int a, int b) {
        System.out.println("Addition operations of a + b = " + (a + b));
    }
}

class Subtraction extends Operate {
    void operate(int a, int b) {
        System.out.println("Subtraction operation of a - b = " + (a - b));
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println(Multiple.multiply(1, 3));
        System.out.println(Multiple.multiply(1.1, 3.1));
        System.out.print(Multiple.multiply(1, 3, 10));

        Operate o;
        o = new Addition();
        o.operate(1, 2);
        o = new Subtraction();
        o.operate(1, 2);
    }
}
