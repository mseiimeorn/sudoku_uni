
import java.util.ArrayList;
import java.util.Random;

/*
*
* this class is for selecting a random Sudoku out of those in the file
* and available to do (see also JComboBox)
*
*/


/**
 *
 * @author Simon
 */
public class SudokuSelector {

    private Random rand = new Random();
    private ArrayList<Sudoku> sudokuList;
    private ArrayList<String> newSudokus;
    private ArrayList<String> solvedSudokus;
    private ArrayList<String> triedSudokus;
    private Sudoku sudoku;

    public SudokuSelector(ArrayList<String> newSudokus, ArrayList<String> solvedSudokus, ArrayList<String> triedSudokus){
        this.sudokuList = new SudokuReader().getSudokus();
        this.newSudokus = newSudokus;
        this.solvedSudokus = solvedSudokus;
        this.triedSudokus = triedSudokus;
    }

    public Sudoku selectNewSudoku() {

        int randomNewSudoku = rand.nextInt(newSudokus.size()-1) + 1;
        String selectedNewSudokuIndex = newSudokus.get(randomNewSudoku);
        for (int i = 0; i < sudokuList.size(); i++) {
            if (selectedNewSudokuIndex.equals(sudokuList.get(i).getGameNumber())) {
                sudoku = sudokuList.get(i);
            }
        }
        return sudoku;
    }

    public Sudoku selectSolvedSudoku() {

        int randomSolvedSudoku = rand.nextInt(solvedSudokus.size()-1) + 1;
        String selectedSolvedSudokuIndex = solvedSudokus.get(randomSolvedSudoku);
        for (int i = 0; i < sudokuList.size(); i++) {
            if (selectedSolvedSudokuIndex.equals(sudokuList.get(i).getGameNumber())) {
                sudoku = sudokuList.get(i);
            }
        }
        return sudoku;
    }

    public Sudoku selectTriedSudoku() {
        int randomTriedSudoku = rand.nextInt(triedSudokus.size()-1) + 1;
        String selectedTriedSudokuIndex = triedSudokus.get(randomTriedSudoku);
        for (int i = 0; i < sudokuList.size(); i++) {
            if (selectedTriedSudokuIndex.equals(sudokuList.get(i).getGameNumber())) {
                sudoku = sudokuList.get(i);
            }
        }
        return sudoku;
    }
}
