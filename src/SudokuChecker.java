
import java.util.ArrayList;
import java.util.Arrays;

/*
*
* This Sudoku Solver is adapted from
* http://www.programming-algorithms.net/article/42521/Sudoku
* by Pavel Micka
*
*/



/**
 *
 * @author Simon
 */
public class SudokuChecker {

    private final int SUDOKU_SIZE = 4;
    private final int SQUARE_SIZE = 2;
    private final int EMPTY = 0;
    private int[][] solution;
    private ArrayList<String> userInput;
    private ArrayList<Integer> givenCells;
    private boolean compare;
    private ArrayList<int[][]> allSudokus = new ArrayList<>();
    //private int[][] emptyArray = new int[SUDOKU_SIZE][SUDOKU_SIZE];
    private int q = 0; //counter for SudokuGenerator;
    private String solutionAsString;

    public SudokuChecker(ArrayList<String> userInput, ArrayList<Integer> givenCells) {
        this.userInput = userInput;
        this.givenCells = givenCells;
        this.solutionAsString = "";
        this.compare = compare(this.userInput, this.givenCells);
    }

    /*
    *
    * this was originally thought of being a helping constructor
    * for the Sudoku Generator
    *
     */
//    public SudokuChecker(int[][] randomArray) {
//        
//        solveSudoku(randomArray);
//        
//        System.out.println("allSudokus");
//        for(int i=0; i<getAllSudokus().size(); i++){
//            for(int j=0; j<getAllSudokus().get(i).length; j++){
//                for(int k=0; k<getAllSudokus().get(i)[j].length; k++){
//                    System.out.print(getAllSudokus().get(i)[j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//        
//        System.out.println(getCounter()); 
////        saveToFile();
//    }
    public void solveSudoku(int[][] array) {

        boolean[][] fixed = new boolean[SUDOKU_SIZE][SUDOKU_SIZE];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (array[i][j] != 0) {
                    fixed[i][j] = true;
                }
            }
        }

        int x = -1;
        int y = 0;

        do {
            x = x + 1; //shift to the next cell

            boolean overflow = x >= SUDOKU_SIZE; //row overflow?

            if (overflow) {
                x = 0;
                y += 1;
            }
        } while (fixed[y][x]); //while the cell is fixed (part of the initial setting)

        for (int i = 1; i <= SUDOKU_SIZE; i++) {
            solve(array, fixed, x, y, i);
        }

    }

    /*
     *
     * Solves the Sudoku
     *
     */
    public void solve(int[][] array, boolean[][] fixed, int x, int y, int value) {

        if (!checkConsistency(array, x, y, value)) {
            return; //the solution is not consistent
        }
        array[y][x] = value; //set

        do {
            x = x + 1; //shift to the next cell

            boolean overflow = x >= SUDOKU_SIZE; //row overflow?

            if (overflow) {
                x = 0;
                y += 1;

                if (y == SUDOKU_SIZE) { //column overflow? --> solution is complete
                    setSolutionAsString(array);
                    solution = new int[4][4];
                    for (int i = 0; i < array.length; i++) {
                        for (int j = 0; j < array[i].length; j++) {
                            solution[i][j] = array[i][j];
                        }
                    }
                    this.allSudokus.add(solution);
                    q++;
                    setCounter(q);
                    return;
                }
            }
        } while (fixed[y][x]); //while the field is fixed (part of the initial setting)

        for (int i = 1; i <= SUDOKU_SIZE; i++) { //backtrack
            solve(array, fixed, x, y, i);
        }

        array[y][x] = EMPTY;
        return; //reset the cell (otherwise it would infere with the backtracking algorithm)
    }

    /*
     *
     * Checks, if the partial solution is consistent
     *
     */
    public boolean checkConsistency(int[][] array, int x, int y, int value) {

        //column
        for (int i = 0; i < array.length; i++) {
            if (i != y && array[i][x] == value) {
                return false;
            }
        }

        //row
        for (int i = 0; i < array[y].length; i++) {
            if (i != x && array[y][i] == value) {
                return false;
            }
        }

        //group
        int vertical = y / SQUARE_SIZE; //vertical row index
        int horizontal = x / SQUARE_SIZE; //horizontal row index

        for (int i = vertical * SQUARE_SIZE; i < vertical * SQUARE_SIZE + SQUARE_SIZE; i++) {
            for (int j = horizontal * SQUARE_SIZE; j < horizontal * SQUARE_SIZE + SQUARE_SIZE; j++) {
                if (array[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setSolutionAsString(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                this.solutionAsString += solution[i][j] + " | ";
            }
            solutionAsString = solutionAsString.substring(0, solutionAsString.length()-2);
            solutionAsString += "\n";
        }
    }

    public String getSolutionAsString() {
        return solutionAsString;        
    }

    /*
     *
     * Getter and Setter for solution array
     *
     */
    public int[][] getSolution() {
        return solution;
    }

    public void setSolution(int[][] solution) {
        this.solution = solution;
    }

    public ArrayList<int[][]> getAllSudokus() {
        return allSudokus;
    }

    public void setCounter(int q) {
        this.q = q;
    }

    public int getCounter() {
        return q;
    }

    /*
     *
     * compare method for comparing userInput with solution
     *
     */
    public boolean compare(ArrayList<String> userInput, ArrayList<Integer> givenCells) {

        //converting userInput into array[][]
        String[][] userInputArray = new String[SUDOKU_SIZE][SUDOKU_SIZE];

        //invert array
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length; j++) {
                if (i < 2 && j < 2) {
                    userInputArray[i][j] = userInput.get((2 * i + j));
                } else if (i < 2 && j >= 2) {
                    userInputArray[i][j] = userInput.get((2 * i + j) + 2);
                } else if (i >= 2 && j < 2) {
                    userInputArray[i][j] = userInput.get((2 * i + j) + 4);
                } else if (i >= 2 && j >= 2) {
                    userInputArray[i][j] = userInput.get((2 * i + j) + 6);
                }
            }
        }

        //converting givenCells into array[][]
        int[][] toSolve = new int[SUDOKU_SIZE][SUDOKU_SIZE];

        //invert Array
        for (int i = 0; i < toSolve.length; i++) {
            for (int j = 0; j < toSolve[i].length; j++) {
                if (i < 2 && j < 2) {
                    toSolve[i][j] = givenCells.get((2 * i + j));
                } else if (i < 2 && j >= 2) {
                    toSolve[i][j] = givenCells.get((2 * i + j) + 2);
                } else if (i >= 2 && j < 2) {
                    toSolve[i][j] = givenCells.get((2 * i + j) + 4);
                } else if (i >= 2 && j >= 2) {
                    toSolve[i][j] = givenCells.get((2 * i + j) + 6);
                }
            }
        }

        //run solver
        solveSudoku(toSolve);
        //get solution
        this.solution = getSolution();
        //converting solution into String[][]
        String[][] solutionStringArray = new String[SUDOKU_SIZE][SUDOKU_SIZE];
        for (int i = 0; i < solutionStringArray.length; i++) {
            for (int j = 0; j < solutionStringArray[i].length; j++) {
                solutionStringArray[i][j] = Integer.toString(solution[i][j]);
            }
        }

        //compare userInputArray with solutionString
        if (Arrays.deepEquals(solutionStringArray, userInputArray)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCompare() {
        return compare;
    }

    public void setCompare(boolean compare) {
        this.compare = compare;
    }

    /*
    *
    * Used to save all 4x4 Sudokus // for the sudoku Generator
    *
     */
//    private void saveToFile() {
//    FileWriter f = null;
//        try {
//            f = new FileWriter(new File("./src/allSudokus.dat"));
//            for(int i=0; i<getAllSudokus().size(); i++){
//                f.write(i + "\n");
//                for(int j=0; j<getAllSudokus().get(i).length; j++){
//                    for(int k=0; k<getAllSudokus().get(i)[j].length; k++){
//                        f.write(getAllSudokus().get(i)[j][k] + " ");
//                    }
//                    f.write("\n");
//                }  
//        }
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage() + "\n" + ex.getStackTrace());
//        } finally {
//            try {
//                f.close();
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage() + "\n" + ex.getStackTrace());
//            }
//        }
//    
//    }
}
