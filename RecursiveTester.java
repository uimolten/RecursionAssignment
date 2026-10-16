/*  Student information for assignment:
 *
 *  On OUR honor, RIONN  and ETHAN , this programming assignment is OUR own work
 *  and WE have not provided this code to any other student.
 *
 *  Number of slip days used:0
 *
 *  Student 1 Rionn Tuscano
 *  UTEID: rrt873
 *  email address: rrt873@my.utexas.edu
 *
 *  Student 2 Ethan Wooten
 *  UTEID:emw3442 
 *  email address:emw3442@my.utexas.edu
 *
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Tester class for the methods in Recursive.java
 */
public class RecursiveTester {

    // run the tests
    public static void main(String[] args) {
        // doBinaryTests();
        // doReverseTests();
        // doNextIsDoubleTests();
        // doListMnemonicsTests();
        // doCarpetTest();
        // doMazeTests();
        // doFlowOffMapTests();
        // doFairTeamsTests();
        studentTests();
    }

    // post: run student test
    private static void studentTests() {
        // CS314 students put your tests here
        // Tests 1 & 2 - getBinary

        System.out.println("Test 1 - getBinary(int n) method");
        String expected = "1010101";
        if (Recursive.getBinary(85).equals(expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Passed test 1");
        }

        System.out.println("\nTest 2 - getBinary(int n) method");
        expected = "1000110101011";
        if (Recursive.getBinary(4523).equals(expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Passed test 2");
        }

        // Test 3 & 4 - revString
        System.out.println("\nTest 3 - revString(String target) method");
        expected = "!gnirtS desreveR a si sihT";
        if (Recursive.revString("This is a Reversed String").equals(expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Passed test 3");
        }

        System.out.println("\nTest 4 - revString(String target) method");
        expected = "W";
        if (Recursive.revString("W").equals(expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Passed test 4");
        }

        // Test 5 & 6 - nextIsDouble
        System.out.println("\nTest 5 - nextIsDouble(int[] data) method");
        int intExpected = 0;
        int[] arrayOfInts = { 1, 3, 5, 7, 9, 0, 8 };
        if (Recursive.nextIsDouble(arrayOfInts) == intExpected) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Passed test 5");
        }

        System.out.println("\nTest 6 - nextIsDouble(int[] data) method");
        intExpected = 1;
        arrayOfInts = new int[] { 1, 3, 6, 7, 9, 0, 8 };
        if (Recursive.nextIsDouble(arrayOfInts) == intExpected) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Passed test 6");
        }

        // tests 7 & 8 - listMnemonics
        System.out.println("\nTest 7 - listMnemonics(String number) method");
        ArrayList<String> expectedMnemonics = new ArrayList<>();
        String[] combinations = { "AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF" };
        for (String c : combinations) {
            expectedMnemonics.add(c);
        }
        ArrayList<String> actualMnemonics = Recursive.listMnemonics("23");
        if (actualMnemonics.size() == expectedMnemonics.size() && actualMnemonics.containsAll(expectedMnemonics)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Passed test 7");
        }

        System.out.println("\nTest 8 - listMnemonics(String number) method");
        expectedMnemonics = new ArrayList<>();
        combinations = new String[] { "PW", "PX", "PY", "PZ", "QW", "QX", "QY", "QZ",
                "RW", "RX", "RY", "RZ", "SW", "SX", "SY", "SZ" };
        for (String c : combinations) {
            expectedMnemonics.add(c);
        }
        actualMnemonics = Recursive.listMnemonics("79");
        if (actualMnemonics.size() == expectedMnemonics.size() && actualMnemonics.containsAll(expectedMnemonics)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Passed test 8");
        }

        // Test 9 & 10 - canFlowOffMap
        System.out.println("\nTest 9 - canFlowOffMap(int[][] map, int row, int col)");
        int[][] studentWorld = {
                { 67, 67, 66, 67, 67, 67 },
                { 67, 67, 65, 67, 67, 67 },
                { 67, 67, 64, 63, 62, 67 },
                { 67, 67, 67, 67, 61, 67 },
                { 67, 67, 23, 59, 60, 67 },
                { 67, 67, 57, 58, 67, 67 },
                { 67, 55, 56, 67, 67, 67 },
                { 67, 54, 67, 67, 67, 67 }
        };

        if (Recursive.canFlowOffMap(studentWorld, 2, 1)) {
            System.out.println("Passed test 9");
        } else {
            System.out.println("Failed test 9");
        }

        System.out.println("\nTest 10 - canFlowOffMap(int[][] map, int row, int col)");
        studentWorld = new int[][] {
                { 5, 5, 5 },
                { 5, 0, 5 },
                { 5, 5, 5 }
        };

        if (!Recursive.canFlowOffMap(studentWorld, 1, 1)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }

        // Tests 11 & 12 - minDifference
        System.out.println("\nTest 11 - minDifference(int numTeams, int[] abilities) method");
        int[] abilities = { 8, 8, 4, 4 };
        intExpected = 0;
        int actual = Recursive.minDifference(2, abilities);
        if (actual == intExpected) {
            System.out.println("Passed test 11");
        } else {
            System.out.println("Failed test 11");
            System.out.println("Expected result: " + intExpected);
            System.out.println("Actual result  : " + actual);
        }

        System.out.println("\nTest 12 - minDifference(int numTeams, int[] abilities) method");
        abilities = new int[] { 9, 7, 5, 3 };
        intExpected = 2;
        actual = Recursive.minDifference(3, abilities);
        if (actual == intExpected) {
            System.out.println("Passed test 12");
        } else {
            System.out.println("Failed test 12");
            System.out.println("Expected result: " + intExpected);
            System.out.println("Actual result  : " + actual);
        }

        // Tests 13 & 14 - canEscapeMaze
        System.out.println("\nTest 13 - canEscapeMaze(char[][] rawMaze) method");
        char[][] studentMaze = makeMaze("SG**$**GE", 3);
        intExpected = 2;
        actual = Recursive.canEscapeMaze(studentMaze);
        if (actual == intExpected) {
            System.out.println("Passed test 13");
        } else {
            System.out.println("Failed test 13");
            System.out.println("Expected result: " + intExpected);
            System.out.println("Actual result  : " + actual);
        }

        System.out.println("\nTest 14 - canEscapeMaze(char[][] rawMaze) method");
        studentMaze = makeMaze("SGE*****$***", 3);
        intExpected = 1;
        actual = Recursive.canEscapeMaze(studentMaze);
        if (actual == intExpected) {
            System.out.println("Passed test 14");
        } else {
            System.out.println("Failed test 14");
            System.out.println("Expected result: " + intExpected);
            System.out.println("Actual result  : " + actual);
        }

    }

    private static void doMazeTests() {
        int mazeTestNum = 1;
        runMazeTest("$GSGE", 1, 2, mazeTestNum++);
        runMazeTest("$Y$SGE", 1, 1, mazeTestNum++);
        String maze = "GGSGG**GGGGG";
        runMazeTest(maze, 3, 0, mazeTestNum++);
        maze = "GSGGG**GGEGG";
        runMazeTest(maze, 3, 2, mazeTestNum++);
        maze = "*EY****YYYYYY**YYYSY";
        runMazeTest(maze, 5, 0, mazeTestNum++);
        maze = "**$****G**ESGG$**G****$**";
        runMazeTest(maze, 5, 1, mazeTestNum++);
        maze = "*G**S**$*E**GG$*GGG***$G*";
        runMazeTest(maze, 5, 2, mazeTestNum++);
        maze = "**$****G**ESGG$**G*$**$**";
        runMazeTest(maze, 5, 1, mazeTestNum++);
        maze = "EYSG$";
        runMazeTest(maze, 1, 2, mazeTestNum++);
        maze = "EYYGGGYGSGGG$GG";
        runMazeTest(maze, 3, 2, mazeTestNum++);
        maze = "EGG$$$GGSGG$$$$";
        runMazeTest(maze, 3, 2, mazeTestNum++);
        maze = "EYY$$$YYSG***YYG$$$$";
        runMazeTest(maze, 4, 2, mazeTestNum++);
        maze = "EYY$$$YYSG****YG$$$$";
        runMazeTest(maze, 4, 1, mazeTestNum++);
        maze = "EYY$$$**SGY***YG$$$$";
        runMazeTest(maze, 4, 2, mazeTestNum++);
    }

    private static void runMazeTest(String rawMaze, int rows, int expected, int num) {
        char[][] maze = makeMaze(rawMaze, rows);
        System.out.println("Can escape maze test number " + num);
        printMaze(maze);
        int actual = Recursive.canEscapeMaze(maze);
        if (expected == actual) {
            System.out.println("passed test " + num);
        } else {
            System.out.println("FAILED TEST " + num);
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
        System.out.println();
    }

    // print the given maze
    // pre: none
    private static void printMaze(char[][] maze) {
        if (maze == null) {
            System.out.println("NO MAZE GIVEN");
        } else {
            for (char[] row : maze) {
                for (char c : row) {
                    System.out.print(c);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    // generate a char[][] given the raw string
    // pre: rawMaze != null, rawMaze.length() % rows == 0
    private static char[][] makeMaze(String rawMaze, int rows) {
        if (rawMaze == null || rawMaze.length() % rows != 0) {
            throw new IllegalArgumentException("Violation of precondition in makeMaze."
                    + "Either raw data is null or left over values: ");
        }
        int cols = rawMaze.length() / rows;
        char[][] result = new char[rows][cols];
        int rawIndex = 0;
        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[0].length; c++) {
                result[r][c] = rawMaze.charAt(rawIndex);
                rawIndex++;
            }
        }
        return result;
    }

    // Test the Sierpinski carpet method.
    private static void doCarpetTest() {
        Recursive.drawCarpet(729, 4);
        Recursive.drawCarpet(729, 1);
    }

    private static void doFairTeamsTests() {
        // System.out.println("Stress test for minDifference - may take up to a
        // minute");
        // int[] testerArr = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60,
        // 65, 70, 75, 100000};
        // Stopwatch s = new Stopwatch();
        // s.start();
        // int actualInt = Recursive.minDifference(4, testerArr);
        // s.stop();
        // System.out.println("Time to solve for 16 people on 4 teams: " + s.time() +
        // "\n");
        // System.out.println(actualInt);

        int[] abilities = { 1, 2, 3, 4, 5, 6, 7 };
        showFairTeamsResults(Recursive.minDifference(3, abilities), 1, 1);
        showFairTeamsResults(Recursive.minDifference(5, abilities), 2, 2);
        showFairTeamsResults(Recursive.minDifference(6, abilities), 4, 3);

        abilities = new int[] { 1, 12, 46, 60, 53, 86, 72, 79, 44, 7 };
        showFairTeamsResults(Recursive.minDifference(3, abilities), 3, 4);
        showFairTeamsResults(Recursive.minDifference(5, abilities), 19, 5);

        abilities = new int[] { 10, 10, 7, 7, 7 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 1, 6);

        abilities = new int[] { -10, -10, -8, -8, -8 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 4, 7);

        abilities = new int[] { -5, 5, 10, 5, 10, -15 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 0, 8);
    }

    // Show the results of a fair teams test by comparing actual and expected
    // result.
    private static void showFairTeamsResults(int actual, int expected, int testNum) {
        if (actual == expected) {
            System.out.println("Test " + testNum + " passed. min difference.");
        } else {
            System.out.println("Test " + testNum + " failed. min difference.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
    }

    private static void doFlowOffMapTests() {
        int testNum = 1;
        int[][] world = { { 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5 },
                { 5, 5, 4, 4, 5, 5 },
                { 5, 5, 3, 3, 5, 5 },
                { 5, 5, 2, 2, 5, 5 },
                { 5, 5, 5, 1, 5, 5 },
                { 5, 5, 5, -2, 5, 5 } };

        doOneFlowTest(world, 0, 0, true, testNum++);
        doOneFlowTest(world, 1, 1, false, testNum++);
        doOneFlowTest(world, 3, 3, true, testNum++);
        doOneFlowTest(world, 1, 5, true, testNum++);

        world = new int[][] { { 10, 10, 10, 10, 10, 10, 10 },
                { 10, 10, 10, 5, 10, 10, 10 },
                { 10, 10, 10, 6, 10, 10, 10 },
                { 10, 10, 10, 7, 10, 10, 10 },
                { 5, 6, 7, 8, 7, 6, 10 },
                { 10, 10, 10, 7, 10, 10, 10 },
                { 10, 10, 10, 6, 10, 10, 10 },
                { 10, 10, 10, 5, 10, 10, 10 },
                { 10, 10, 10, 10, 10, 10, 10 } };

        doOneFlowTest(world, 3, 3, false, testNum++);
        doOneFlowTest(world, 4, 3, true, testNum++);
        System.out.println();
    }

    private static void doOneFlowTest(int[][] world, int r, int c,
            boolean expected, int testNum) {

        System.out.println("Can Flow Off Map Test Number " + testNum);
        boolean actual = Recursive.canFlowOffMap(world, r, c);
        System.out.println("Start location = " + r + ", " + c);
        System.out.println("Expected result = " + expected + " actual result = " + actual);
        if (expected == actual) {
            System.out.println("passed test " + testNum + " can flow off map.");
        } else {
            System.out.println("FAILED TEST " + testNum + " can flow off map.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
        System.out.println();
    }

    private static void doListMnemonicsTests() {
        ArrayList<String> mnemonics = Recursive.listMnemonics("1");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1");
        if (mnemonics.equals(expected)) {
            System.out.println("Test 1 passed. Phone mnemonics.");
        } else {
            System.out.println("Test1 failed. Phone mnemonics.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + mnemonics);
        }

        mnemonics = Recursive.listMnemonics("22");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("AA");
        expected.add("AB");
        expected.add("AC");
        expected.add("BA");
        expected.add("BB");
        expected.add("BC");
        expected.add("CA");
        expected.add("CB");
        expected.add("CC");
        Collections.sort(expected);
        if (mnemonics.equals(expected)) {
            System.out.println("Test 2 passed. Phone mnemonics.");
        } else {
            System.out.println("Test 2 failed. Phone mnemonics.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + mnemonics);
        }

        mnemonics = Recursive.listMnemonics("110010");
        expected.clear();
        expected.add("110010");
        if (mnemonics.equals(expected)) {
            System.out.println("Test 3 passed. Phone mnemonics.");
        } else {
            System.out.println("Test 3 failed. Phone mnemonics.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + mnemonics);
        }
        System.out.println();

    }

    private static void doNextIsDoubleTests() {
        int[] numsForDouble = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
        int actualDouble = Recursive.nextIsDouble(numsForDouble);
        int expectedDouble = 8;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 1 passed. next is double.");
        } else {
            System.out.println("Test 1 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 1, 3, 4, 2, 32, 8, 128, -5, 6 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 2 passed. next is double.");
        } else {
            System.out.println("Test 2 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 1, 0, 0, -5, -10, 32, 64, 128, 2, 9, 18 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 5;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 3 passed. next is double.");
        } else {
            System.out.println("Test 3 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 37 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 4 passed. next is double.");
        } else {
            System.out.println("Test 4 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 37, 74 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 1;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 5 passed. next is double.");
        } else {
            System.out.println("Test 5 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }
        System.out.println();
    }

    private static void doReverseTests() {
        String actualRev = Recursive.revString("target");
        String expectedRev = "tegrat";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test 1 passed. reverse string.");
        } else {
            System.out.println("Test 1 failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        actualRev = Recursive.revString("Calvin and Hobbes");
        expectedRev = "sebboH dna nivlaC";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test 2 passed. reverse string.");
        } else {
            System.out.println("Test 2 failed. reverse string. expected: "
                    + expectedRev + ", actual: " + actualRev);
        }

        actualRev = Recursive.revString("U");
        expectedRev = "U";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test 3 passed. reverse string.");
        } else {
            System.out.println("Test 3 failed. reverse string. expected: "
                    + expectedRev + ", actual: " + actualRev);
        }
        System.out.println();
    }

    private static void doBinaryTests() {
        String actualBinary = Recursive.getBinary(13);
        String expectedBinary = "1101";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test 1 passed. get binary.");
        } else {
            System.out.println("Test 1 failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        actualBinary = Recursive.getBinary(0);
        expectedBinary = "0";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test 2 passed. get binary.");
        } else {
            System.out.println("Test 2 failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        actualBinary = Recursive.getBinary(-35);
        expectedBinary = "-100011";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test 3 passed. get binary.");
        } else {
            System.out.println("Test 3failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        actualBinary = Recursive.getBinary(1);
        expectedBinary = "1";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test 4 passed. get binary.");
        } else {
            System.out.println("Test 4 failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        actualBinary = Recursive.getBinary(64);
        expectedBinary = "1000000";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test 5 passed. get binary");
        } else {
            System.out.println("Test 5 failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }
        System.out.println();
    }

}
