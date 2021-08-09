import java.util.Arrays;

public class GalleryIllumination {

    public static boolean containsChar(String s, char isLamp) {
        if (s.length() == 0)
            return false;
        else
            return s.charAt(0) == isLamp || containsChar(s.substring(1), isLamp);
    }

    public static int countDarkCells(int R, int C, String[] floorPlan) {
        char[][] floorStructure = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                floorStructure[i][j] = floorPlan[i].charAt(j);
            }
        }

        for (int i = 0; i < floorStructure.length; i++) {
            for (int j = 0; j < floorStructure[0].length; j++) {
                if (floorStructure[i][j] == 'O') {
                    for (int rowUpdate = 0; rowUpdate >= 0 && rowUpdate < floorStructure[0].length; rowUpdate++) {
                        if (floorStructure[i][rowUpdate] == '#') {
                            for (int updateWallInRow = rowUpdate - 1; updateWallInRow >= 0; updateWallInRow--) {
                                if (floorStructure[i][updateWallInRow] == '*') {
                                    floorStructure[i][updateWallInRow] = '.';
                                }
                            }
                        }
                        if (floorStructure[i][rowUpdate] == '.') {
                            floorStructure[i][rowUpdate] = '*';
                        }
                    }
                    for (int columnUpdate = 0; columnUpdate >= 0
                            && columnUpdate < floorStructure.length; columnUpdate++) {
                        if (floorStructure[columnUpdate][j] == '#') {
                            for (int updateWallInColumn = columnUpdate
                                    + 1; updateWallInColumn < floorStructure.length; updateWallInColumn++) {
                                if (floorStructure[updateWallInColumn][j] == '*') {
                                    floorStructure[updateWallInColumn][j] = '.';
                                }
                            }
                            break;
                        }
                        if (floorStructure[columnUpdate][j] == '.') {
                            floorStructure[columnUpdate][j] = '*';
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < floorStructure.length; i++) {
            for (int j = 0; j < floorStructure[0].length; j++) {
                if (floorStructure[i][j] == '.') {
                    count++;
                }
            }
        }

        System.out.println("" + Arrays.deepToString(floorStructure));

        return count;
    }

    public static void main(String[] args) {
        int R = 1, C = 1;
        String[] floorPlan = { "0" };

        System.out.println("Result " + countDarkCells(R, C, floorPlan));
    }
}
