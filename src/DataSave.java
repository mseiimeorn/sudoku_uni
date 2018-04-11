
import java.util.ArrayList;

/*
*
* updating the userdata file
*
*/


/**
 *
 * @author Simon
 */
public class DataSave {

    private SudokuChecker sudokuChecker;
    private int indexOfUser;
    private int hsecCalculator;
    private String currentSudoku;
    private int numberOfSolvedGames;
    private int numberOfTriedGames;
    private ArrayList<String> newSudokus;
    private ArrayList<String> solvedSudokus;
    private ArrayList<String> triedSudokus;
    private String updatedAvgTime;
    private UserData userdata;

    public DataSave(UserData userdata, SudokuChecker sudokuChecker, int indexOfUser, int hsecCalculator, Sudoku currentSudoku) {
        this.userdata = userdata;
        this.sudokuChecker = sudokuChecker;
        this.indexOfUser = indexOfUser;
        this.hsecCalculator = hsecCalculator;
        this.currentSudoku = currentSudoku.getGameNumber();

        saveNumberOfSolvedGames();
        saveNumberOfTriedGames();

        newSudokus = convertArrayToArrayList(userdata.getUserList().get(indexOfUser).getNewGames().split(","));
        solvedSudokus = convertArrayToArrayList(userdata.getUserList().get(indexOfUser).getGamesSolved().split(","));
        triedSudokus = convertArrayToArrayList(userdata.getUserList().get(indexOfUser).getGamesTriedNotSolved().split(","));

        updateListOfGames(newSudokus, solvedSudokus, triedSudokus);

        updateAvgTime(userdata.getUserList().get(indexOfUser).getAvgTime(), this.hsecCalculator);

    }

    //updated number of solved Games
    public void saveNumberOfSolvedGames() {
        int number = userdata.getUserList().get(indexOfUser).getNumberOfGamesSolved();

        if (sudokuChecker.isCompare() == true) {
            this.numberOfSolvedGames = number + 1;
        } else {
            this.numberOfSolvedGames = number;
        }
    }

    public int getNumberOfSolvedGames() {
        return this.numberOfSolvedGames;
    }

    //updated number of tried not solved Games
    public void saveNumberOfTriedGames() {
        int number = userdata.getUserList().get(indexOfUser).getNumberOfGamesTriedNotSolved();

        if (sudokuChecker.isCompare() == false) {
            this.numberOfTriedGames = number + 1;
        } else {
            this.numberOfTriedGames = number;
        }
    }

    public int getNumberOfTriedGames() {
        return this.numberOfTriedGames;
    }

    public ArrayList<String> convertArrayToArrayList(String[] sudoku) {
        ArrayList<String> sudokuArrayList = new ArrayList<>();
        for (int i = 0; i < sudoku.length; i++) {
            sudokuArrayList.add(sudoku[i]);
        }
        return sudokuArrayList;
    }

    public String sudokusConvertedToString(ArrayList<String> sudokuArrayList) {
        StringBuilder sudokuString = new StringBuilder();
        for (int i = 1; i < sudokuArrayList.size(); i++) {
            sudokuString.append("," + sudokuArrayList.get(i));
        }
        return sudokuString.toString();
    }

    public void updateListOfGames(ArrayList<String> newSudokus, ArrayList<String> solvedSudokus, ArrayList<String> triedSudokus) {

        if (sudokuChecker.isCompare() == true) {
            if (newSudokus.contains(currentSudoku)) {
                newSudokus.remove(currentSudoku);
            }
            if (triedSudokus.contains(currentSudoku)) {
                triedSudokus.remove(currentSudoku);
            }
            if (!solvedSudokus.contains(currentSudoku)) {
                solvedSudokus.add(currentSudoku);
            }
        } else if (sudokuChecker.isCompare() == false) {
            if (newSudokus.contains(currentSudoku)) {
                newSudokus.remove(currentSudoku);
            }
            if ((!triedSudokus.contains(currentSudoku) && !solvedSudokus.contains(currentSudoku))) {
                triedSudokus.add(currentSudoku);
            }
        }
    }

    //public void setSolvedSudokus()
    public String getNewSudokus() {
        return sudokusConvertedToString(newSudokus);
    }

    public String getSolvedSudokus() {
        return sudokusConvertedToString(solvedSudokus);
    }

    public String getTriedSudokus() {
        return sudokusConvertedToString(triedSudokus);
    }

    public void updateAvgTime(String avgTime, int currentTime) {
        if (sudokuChecker.isCompare() == true) {

            String[] avgTimeSplitted = avgTime.split(":");

            int avgMIN = Integer.parseInt(avgTimeSplitted[0]);
            int avgSEC = Integer.parseInt(avgTimeSplitted[1]);
            int avgHSEC = Integer.parseInt(avgTimeSplitted[2]);

            int numberOfGames = ((getNumberOfSolvedGames() < 2) ? getNumberOfSolvedGames() : 2);
            int updatedAvgHSEC = Math.round(((avgMIN * 6000) + (avgSEC * 100) + (avgHSEC) + (currentTime)) / (float) numberOfGames);
            int updatedAvgMIN = updatedAvgHSEC / 6000;
            updatedAvgHSEC = updatedAvgHSEC % 6000;
            int updatedAvgSEC = updatedAvgHSEC / 100;
            updatedAvgHSEC = updatedAvgHSEC % 100;

            updatedAvgTime = ((updatedAvgMIN < 10) ? "0" : "") + updatedAvgMIN + ":" + ((updatedAvgSEC < 10) ? "0" : "") + updatedAvgSEC + ":" + ((updatedAvgHSEC < 10) ? "0" : "") + updatedAvgHSEC;
        } else {
            updatedAvgTime = avgTime;
        }
    }

    public String getUpdatedAvgTime() {
        return updatedAvgTime;
    }
}
