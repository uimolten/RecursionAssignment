/*  Student information for assignment:
 *
 *  On Our honor, Rionn and Ethan,
 *  this programming assignment is Our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1: Rionn TUscano
 *  UTEID: rrt873
 *  email address: rrt873@my.utexas.edu
 *  Grader name:
 *  Section number: 55010
 *
 *  Student 2: Ethan Wooten
 *  UTEID: emw3442
 *  email address: emw3442@my.utexas.edu
 *
 */

//imports

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Various recursive methods to be implemented.
 * Given shell file for CS314 assignment.
 */
public class Recursive {

    /**
     * Problem 1: convert a base 10 int to binary recursively.
     * <br>
     * pre: n != Integer.MIN_VALUE<br>
     * <br>
     * post: Returns a String that represents N in binary.
     * If n is negative the returned String starts with a '-' char.
     * All subsequent chars in returned String are '1's or '0's.
     * Most significant digit is at position 0
     * 
     * @param n the base 10 int to convert to base 2
     * @return a String that is a binary representation of the parameter n
     */
    public static String getBinary(int n) {
        if (n == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "getBinary. n cannot equal "
                    + "Integer.MIN_VALUE. n: " + n);
        }
        StringBuilder sb = new StringBuilder();
        if (n < 0) {
            sb.append("-" + getBinary(-n));
            return sb.toString();
        }
        if (n < 2) {
            sb.append(n);
            return sb.toString();
        }
        return getBinary(n / 2) + (n % 2);

    }

    /**
     * Problem 2: reverse a String recursively.<br>
     * pre: stringToRev != null<br>
     * post: returns a String that is the reverse of stringToRev
     * 
     * @param stringToRev the String to reverse.
     * @return a String with the characters in stringToRev
     *         in reverse order.
     */
    public static String revString(String stringToRev) {
        if (stringToRev == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }

        int length = stringToRev.length();
        // base case
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return stringToRev;
        }
        return stringToRev.substring(length - 1) + revString(stringToRev.substring(0, length - 1));
    }

    /**
     * Problem 3: Returns the number of elements in data
     * that are followed directly by value that is
     * double that element.
     * pre: data != null
     * post: return the number of elements in data
     * that are followed immediately by double the value
     * 
     * @param data The array to search.
     * @return The number of elements in data that
     *         are followed immediately by a value that is double the element.
     */
    public static int nextIsDouble(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException(
                    "nextIsDouble parameter may not be null.");
        }

        return doubleHelper(data, 0);
    }

    private static int doubleHelper(int[] data, int index) {
        if (index >= data.length - 1) {
            return 0;
        }

        int count = 0;

        if (data[index + 1] % 2 == 0 && data[index + 1] / 2 == data[index]) {
            count = 1;
        }

        return count + doubleHelper(data, index + 1);
    }

    /**
     * Problem 4: Find all combinations of mnemonics
     * for the given number.<br>
     * pre: number != null, number.length() > 0,
     * all characters in number are digits<br>
     * post: see tips section of assignment handout
     * 
     * @param number The number to find mnemonics for
     * @return An ArrayList<String> with all possible mnemonics
     *         for the given number
     */
    public static ArrayList<String> listMnemonics(String number) {
        if (number == null || number.length() == 0 || !allDigits(number)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "listMnemonics");
        }

        ArrayList<String> results = new ArrayList<>(); // to store the mnemonics
        recursiveMnemonics(results, "", number);
        return results;
    }

    /*
     * Helper method for listMnemonics
     * mnemonics stores completed mnemonics
     * mneominicSoFar is a partial (possibly complete) mnemonic
     * digitsLeft are the digits that have not been used
     * from the original number.
     */
    private static void recursiveMnemonics(ArrayList<String> mnemonics,
            String mnemonicSoFar, String digitsLeft) {

        // CS314 students, complete this method
        if (digitsLeft.length() == 0) {
            mnemonics.add(mnemonicSoFar);
            return;
        }
        String temp = digitLetters(digitsLeft.charAt(0));

        for (int i = 0; i < temp.length(); i++) {
            recursiveMnemonics(mnemonics, mnemonicSoFar + temp.charAt(i), digitsLeft.substring(1));
        }
    }

    /*
     * Static code blocks are run once when this class is loaded.
     * Here we create an unmoddifiable list to use with the phone
     * mnemonics method.
     */
    private static final List<String> LETTERS_FOR_NUMBER;
    static {
        String[] letters = { "0", "1", "ABC",
                "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
        ArrayList<String> lettersAsList = new ArrayList<>();
        for (String s : letters) {
            lettersAsList.add(s);
        }
        LETTERS_FOR_NUMBER = Collections.unmodifiableList(lettersAsList);

    }
    // used by method digitLetters

    /*
     * helper method for recursiveMnemonics
     * pre: ch is a digit '0' through '9'
     * post: return the characters associated with
     * this digit on a phone keypad
     */
    private static String digitLetters(char ch) {
        if (ch < '0' || ch > '9') {
            throw new IllegalArgumentException("parameter "
                    + "ch must be a digit, 0 to 9. Given value = " + ch);
        }
        int index = ch - '0';
        return LETTERS_FOR_NUMBER.get(index);
    }

    /*
     * helper method for listMnemonics
     * pre: s != null
     * post: return true if every character in s is
     * a digit ('0' through '9')
     */
    private static boolean allDigits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "allDigits. String s cannot be null.");
        }
        boolean allDigits = true;
        int i = 0;
        while (i < s.length() && allDigits) {
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }

    /**
     * Problem 5: Draw a Sierpinski Carpet.
     * 
     * @param size  the size in pixels of the window
     * @param limit the smallest size of a square in the carpet.
     */
    public static void drawCarpet(int size, int limit) {
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }

    /*
     * Helper method for drawCarpet
     * Draw the individual squares of the carpet.
     * 
     * @param g The Graphics object to use to fill rectangles
     * 
     * @param size the size of the current square
     * 
     * @param limit the smallest allowable size of squares
     * 
     * @param x the x coordinate of the upper left corner of the current square
     * 
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit,
            double x, double y) {
        final int SQUARE_BOUND = 3; // We used 3 as our magic number because each square is divided into 3x3s, so we
                                    // would need to divide size by 3
        if (size > limit) {
            for (int i = 0; i < SQUARE_BOUND; i++) {
                for (int j = 0; j < SQUARE_BOUND; j++) {
                    int newX = (int) x + (i * size / SQUARE_BOUND);
                    int newY = (int) y + (j * size / SQUARE_BOUND);
                    if (i == 1 && j == 1) {
                        // at the center, fill rectangle
                        g.fillRect(newX, newY, size / SQUARE_BOUND, size / SQUARE_BOUND);
                    }
                    drawSquares(g, size / 3, limit, (double) newX, (double) newY);
                }
            }
        }

    }

    /**
     * Problem 6: Determine if water at a given point
     * on a map can flow off the map.
     * <br>
     * pre: map != null, map.length > 0,
     * map is a rectangular matrix, 0 <= row < map.length,
     * 0 <= col < map[0].length
     * <br>
     * post: return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map,
     * false otherwise.
     * 
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     * @return return true if a drop of water starting at the location
     *         specified by row, column can reach the edge of the map, false
     *         otherwise.
     */
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        if (map == null || map.length == 0 || !isRectangular(map)
                || !inbounds(row, col, map)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "canFlowOffMap");
        }
        boolean currentStatus = false;

        // base case, if the current drop is at the border, return true since it can
        // flow off edge.
        if (row == 0 || col == 0 || row == map.length - 1 || col == map[0].length - 1) {
            return true;
        }
        if (isDirectionSafe(map, row, col, 1, 0)) {
            if (canFlowOffMap(map, row + 1, col)) {
                currentStatus = true;
            }
        }
        if (isDirectionSafe(map, row, col, -1, 0)) {

            if (canFlowOffMap(map, row - 1, col)) {
                currentStatus = true;
            }
        }
        if (isDirectionSafe(map, row, col, 0, 1)) {

            if (canFlowOffMap(map, row, col + 1)) {
                currentStatus = true;
            }
        }
        if (isDirectionSafe(map, row, col, 0, -1)) {

            if (canFlowOffMap(map, row, col - 1)) {
                currentStatus = true;
            }
        }

        return currentStatus;
    }

    private static boolean isDirectionSafe(int[][] map, int row, int col, int rowChange, int colChange) {
        int r = row + rowChange;
        int c = col + colChange;
        if (map[row][col] > map[r][c]) {
            return true;
        }
        return false;
    }

    /*
     * helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null,
     */
    private static boolean inbounds(int r, int c, int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null.");
        }
        return r >= 0 && r < mat.length && mat[r] != null
                && c >= 0 && c < mat[r].length;
    }

    /*
     * helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }

    /**
     * Problem 7: Find the minimum difference possible between teams
     * based on ability scores. The number of teams may be greater than 2.
     * The goal is to minimize the difference between the team with the
     * maximum total ability and the team with the minimum total ability.
     * <br>
     * pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
     * <br>
     * post: return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability.
     * 
     * @param numTeams  the number of teams to form.
     *                  Every team must have at least one member
     * @param abilities the ability scores of the people to distribute
     * @return return the minimum possible difference between the team
     *         with the maximum total ability and the team with the minimum total
     *         ability. The return value will be greater than or equal to 0.
     */
    public static int minDifference(int numTeams, int[] abilities) {
        int[][] teamStats = new int[2][numTeams];

        return differenceHelper(0, numTeams, abilities, teamStats);
    }

    private static int differenceHelper(int index, int numTeams, int[] abilities, int[][] teamStats) {
        int bestDifference = Integer.MAX_VALUE;
        // base case
        if (index == abilities.length) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // check if every team has a person
            for (int i = 0; i < numTeams; i++) {
                if (teamStats[1][i] < 1) {
                    return Integer.MAX_VALUE;
                }
            }
            // calcualte the bestDifference
            for (int i = 0; i < numTeams; i++) {
                if (teamStats[0][i] > max) {
                    max = teamStats[0][i];
                }
                if (teamStats[0][i] < min) {
                    min = teamStats[0][i];
                }

                bestDifference = max - min;
            }
            return bestDifference;

        }

        for (int i = 0; i < numTeams; i++) {
            teamStats[0][i] += abilities[index];
            teamStats[1][i]++;
            int result = differenceHelper(index + 1, numTeams, abilities, teamStats);
            if (result < bestDifference) {
                bestDifference = result;
            }
            teamStats[0][i] -= abilities[index];
            teamStats[1][i]--;
        }
        return bestDifference;

    }

    /**
     * Problem 8: Maze solver.
     * <br>
     * pre: board != null
     * <br>
     * pre: board is a rectangular matrix
     * <br>
     * pre: board only contains characters 'S', 'E', '$', 'G', 'Y', and '*'
     * <br>
     * pre: there is a single 'S' character present
     * <br>
     * post: rawMaze is not altered as a result of this method.
     * Return 2 if it is possible to escape the maze after
     * collecting all the coins.
     * Return 1 if it is possible to escape the maze
     * but without collecting all the coins.
     * Return 0 if it is not possible
     * to escape the maze. More details in the assignment handout.
     * 
     * @param rawMaze represents the maze we want to escape.
     *                rawMaze is not altered as a result of this method.
     * @return per the post condition
     */
    public static int canEscapeMaze(char[][] rawMaze) {
        // search for start
        int sRow = -1;
        int sCol = -1;
        boolean containsExit = false;
        int totalCoinCount = 0;

        // preprocessing
        for (int r = 0; r < rawMaze.length; r++) {
            for (int c = 0; c < rawMaze[0].length; c++) {
                if (rawMaze[r][c] == 'S') {
                    sRow = r;
                    sCol = c;
                }
                if (rawMaze[r][c] == 'E') {
                    containsExit = true;
                }
                if (rawMaze[r][c] == '$') {
                    totalCoinCount++;
                }
            }
        }

        return mazeHelper(rawMaze, sRow, sCol, containsExit, totalCoinCount);
    }

    private static int mazeHelper(char[][] rawMaze, int r, int c, boolean containsExit, int totalCoinCount) {
        int coinCount = 0;
        int bestPath = 0;
        if (rawMaze[r][c] == 'E') {
            bestPath = totalCoinCount == coinCount ? 2 : 1;
            return bestPath;
        }

        if (!containsExit) {
            return 0;
        }

        // check directions recursively
        if (isMazeDirectionSafe(rawMaze, r, c, 1, 0)) {
            char org = rawMaze[r][c];
            rawMaze[r][c] = changeVisited(org);
            bestPath = mazeHelper(rawMaze, r + 1, c, containsExit, totalCoinCount);
            rawMaze[r][c] = org;
        }
        if (isMazeDirectionSafe(rawMaze, r, c, -1, 0)) {
            char org = rawMaze[r][c];
            rawMaze[r][c] = changeVisited(org);
            bestPath = mazeHelper(rawMaze, r - 1, c, containsExit, totalCoinCount);
            rawMaze[r][c] = org;
        }
        if (isMazeDirectionSafe(rawMaze, r, c, 0, 1)) {
            char org = rawMaze[r][c];
            rawMaze[r][c] = changeVisited(org);
            bestPath = mazeHelper(rawMaze, r, c + 1, containsExit, totalCoinCount);
            rawMaze[r][c] = org;
        }
        if (isMazeDirectionSafe(rawMaze, r, c, 0, -1)) {
            char org = rawMaze[r][c];
            rawMaze[r][c] = changeVisited(org);
            bestPath = mazeHelper(rawMaze, r, c - 1, containsExit, totalCoinCount);
            rawMaze[r][c] = org;
        }

        return bestPath;
    }

    private static boolean isMazeDirectionSafe(char[][] maze, int row, int col, int rowChange, int colChange) {
        int r = row + rowChange;
        int c = col + colChange;
        if (r >= maze.length || c >= maze[0].length || r < 0 || c < 0) {
            return false;
        }
        if (maze[r][c] == 'G' || maze[r][c] == 'Y' || maze[r][c] == '$' || maze[r][c] == 'E') {
            return true;
        }
        return false;
    }

    private static char changeVisited(char c) {
        if (c == 'S') {
            return 'G';
        }
        if (c == 'G') {
            return 'Y';
        }
        if (c == 'Y') {
            return '*';
        }
        if (c == '$') {
            return 'Y';
        }
        return '*';

    }
}