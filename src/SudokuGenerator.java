/*
*
* this class was an attempt to make a totally random Generator
*
*/


//import java.util.ArrayList;
//import java.util.Random;
//
///**
// *
// * @author Simon
// */
//public class SudokuGenerator {
//
//    private final int SUDOKU_SIZE = 4;
//    private int[][] chosenSudoku;
//    private int[][] helpSudoku;
//    private ArrayList<int[][]> sudokus;
//    private int counter;
//    private int[][] sudoku;
//    private SudokuChecker checker;
//
//    public SudokuGenerator(ArrayList<int[][]> allSudokus) {
//        this.sudokus = allSudokus;
//        this.counter = 0;
//        chosenSudoku = chooseSudoku();
//        helpSudoku = chosenSudoku;
//        generateSudoku(chosenSudoku);
//        for (int i = 0; i < sudoku.length; i++) {
//            for (int j = 0; j < sudoku[i].length; j++) {
//                System.out.print(sudoku[i][j]);
//            }
//            System.out.println();
//        }
//
//    }
//
//    public int[][] chooseSudoku() {
//        chosenSudoku = new int[4][4];
//        int chosenSudokuIndex = new Random().nextInt(sudokus.size());
//
//        for (int i = 0; i < sudokus.get(chosenSudokuIndex).length; i++) {
//            for (int j = 0; j < sudokus.get(chosenSudokuIndex)[i].length; j++) {
//                chosenSudoku[i][j] = sudokus.get(chosenSudokuIndex)[i][j];
//            }
//        }
//        System.out.println("chosen Sudoku;");
//        for (int i = 0; i < sudokus.get(chosenSudokuIndex).length; i++) {
//            for (int j = 0; j < sudokus.get(chosenSudokuIndex)[i].length; j++) {
//                System.out.print(chosenSudoku[i][j]);
//            }
//            System.out.println();
//        }
//        return chosenSudoku;
//    }
//
//    public void generateSudoku(int[][] chosenSudoku) {
//        int x = new Random().nextInt(SUDOKU_SIZE);
//        int y = new Random().nextInt(SUDOKU_SIZE);
//
//        while (counter < 12) {
//            if (chosenSudoku[x][y] != 0) {
//                int z = chosenSudoku[x][y];
//                System.out.println("zzzzzzz:");
//                System.out.println(z);
//
//                chosenSudoku[x][y] = 0;
//
//                System.out.println("with  zero  ");
//                for (int i = 0; i < chosenSudoku.length; i++) {
//                    for (int j = 0; j < chosenSudoku[i].length; j++) {
//                        System.out.print(chosenSudoku[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//
//                int[][] tempSudoku = new int[4][4];
//                for (int i = 0; i < chosenSudoku.length; i++) {
//                    for (int j = 0; j < chosenSudoku[i].length; j++) {
//                        tempSudoku[i][j] = chosenSudoku[i][j];
//                    }
//                }
//
//                System.out.println("tempSudoku: ");
//
//                for (int i = 0; i < tempSudoku.length; i++) {
//                    for (int j = 0; j < tempSudoku[i].length; j++) {
//                        System.out.print(tempSudoku[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//
//                checker = new SudokuChecker(chosenSudoku);
//                
//                if (checker.getCounter() <= 1) {
//                    generateSudoku(tempSudoku);
//                    counter++;
//                    if (counter == 12) {
//                        return;
//                    }
//                } else if (checker.getCounter() > 1) {
//                    generateSudoku(helpSudoku);
//                }
//            } else {
//                generateSudoku(chosenSudoku);
//            }
//        }
//    }
//}
