


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
*
* Reader for Sudokus
*
*/


/**
 *
 * @author Simon
 */
public class SudokuReader {

    private ArrayList<Sudoku> sudokus = new ArrayList<>();
    private final byte SIZE = 4;
    private final String SUDOKUFILE_PATH = ("./src/sudokus.dat"); //E:\_UNI\NetBeansProjects\Sudoku_Project\src\sudokus.dat

    public SudokuReader(){
        this.sudokus = readSudokuFile();

    }

    public ArrayList<Sudoku> getSudokus() {
        return sudokus;
    }

    //Scan Sudokus
    public ArrayList<Sudoku> readSudokuFile(){
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            File sudokuFile = new File(SUDOKUFILE_PATH);
            
            Scanner scan = new Scanner(sudokuFile);

            while (scan.hasNext()) {
                
                String gameNum = scan.next();

                for (int i = 0; i < (SIZE * SIZE); i++) {
                    int next = scan.nextInt();
                    numbers.add(next);
                }
                sudokus.add(new Sudoku(gameNum, numbers));
                numbers = new ArrayList<>();    
            }
            scan.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SudokuReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sudokus;
    }
}
