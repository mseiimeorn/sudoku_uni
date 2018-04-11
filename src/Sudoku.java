
import java.util.ArrayList;

/*
*
* Defines a Sudokus from the List
*
*/

/**
 *
 * @author Simon
 */
public class Sudoku {

    private String gameNumber;
    private ArrayList<Integer> sudoku;

    public Sudoku(String gameNumber, ArrayList<Integer> sudoku) {
        this.gameNumber = gameNumber;
        this.sudoku = sudoku;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public ArrayList<Integer> getSudoku() {
        return sudoku;
    }

    public void setSudoku(ArrayList<Integer> sudoku) {
        this.sudoku = sudoku;
    }
}
