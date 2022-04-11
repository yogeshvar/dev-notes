import java.util.Arrays;

class PlayGround {
    int arr[][] = null;

    public PlayGround(int rowSize, int columnSize) {
        arr = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void insert(int x, int y, int value) {
        try {
            if (arr[x][y] == Integer.MIN_VALUE) {
                arr[x][y] = value;
                System.out.println("Init location loaded!!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveDown() {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (arr[x][y] == 1) {
                    arr[x][y] = Integer.MIN_VALUE;
                    if (arr[x][y - 1] == 1) {
                        System.out.println("Explosion");
                        return;
                    } else {
                        arr[x][y - 1] = 1;
                    }
                }
            }
        }
    }

    public void moveRight() {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (arr[x][y] == 1) {
                    arr[x][y] = Integer.MIN_VALUE;
                    if (arr[x + 1][y] == 1) {
                        System.out.println("Explosion");
                        return;
                    } else {
                        arr[x + 1][y] = 1;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (arr[x][y] == 1) {
                    arr[x][y] = Integer.MIN_VALUE;
                    if (arr[x - 1][y] == 1) {
                        System.out.println("Explosion");
                        return;
                    } else {
                        arr[x - 1][y] = 1;
                    }
                }
            }
        }
    }

    public void moveUp() {
        System.out.println("Array Length : " + arr.length);
        System.out.println("Array inner length : " + arr[0].length);
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (arr[x][y] == 1) {
                    arr[x][y] = Integer.MIN_VALUE;
                    if (arr[x][y + 1] == 1) {
                        System.out.println("Explosion");
                        return;
                    } else {
                        arr[x][y + 1] = 1;
                    }
                }
            }
        }
    }

    public void prettyTraversal() {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
        insert(x1, y1, 1);
        insert(x2, y2, 1);
        System.out.println("Before Instructions");
        prettyTraversal();
        char[] ch = instructions.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'U') {
                moveUp();
            } else if (ch[i] == 'D') {
                moveDown();
            } else if (ch[i] == 'L') {
                moveLeft();
            } else if (ch[i] == 'R') {
                moveRight();
            }
        }
        return "Safe";
    }

}

public class ExploringRobots {
    public static void main(String[] args) {
        PlayGround playGround = new PlayGround(4, 4);
        String result = playGround.canExplode(1, 0, 2, 0, "U");
        System.out.println("After Instructions");
        playGround.prettyTraversal();
        System.out.println("Result : " + result);
    }
}
