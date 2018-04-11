


import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class UserData {

    private ArrayList<User> userList = new ArrayList<>();
    private String nickName;
    private ArrayList<String> newSudokus = new ArrayList<>();
    private ArrayList<String> solvedSudokus = new ArrayList<>();
    private ArrayList<String> triedSudokus = new ArrayList<>();
    private String[] newSudokusArray = {};
    private String[] solvedSudokusArray = {};
    private String[] triedSudokusArray = {};
    private int numberOfGamesSolved;
    private int numberOfGamesTriedNotSolved;
    private String avgTime;
    private final String USERDATA_FILE = ("./src/userdata.dat"); // E:\_UNI\NetBeansProjects\Sudoku_Project\src\ userdata.dat

    /**
     *
     * Managing List of Users
     *
     */
    public UserData() {
        this.userList = readUserData();
        this.nickName = getNickName();
        this.newSudokusArray = getNewSudokusArray();
        this.solvedSudokusArray = getSolvedSudokusArray();
        this.triedSudokusArray = getTriedSudokusArray();
        this.numberOfGamesSolved = getNumberOfGamesSolved();
        this.numberOfGamesTriedNotSolved = getNumberOfGamesTriedNotSolved();
        this.avgTime = getAvgTime();

        setNewSudokusIndex(this.newSudokusArray);
        this.newSudokus = getNewSudokusIndex();
        setSolvedSudokusIndex(this.solvedSudokusArray);
        this.solvedSudokus = getSolvedSudokusIndex();
        setTriedSudokusIndex(this.triedSudokusArray);
        this.triedSudokus = getTriedSudokusIndex();
    }

    //return a userlist
    public ArrayList<User> getUserList() {
        return userList;
    }

    //read UserFile
    public ArrayList<User> readUserData() {
        File file = new File(USERDATA_FILE);

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (!line.equals("")) {
                    String[] record = line.split(";");
                    userList.add(new User(record[0], record[1], record[2], record[3], Integer.parseInt(record[4]), Integer.parseInt(record[5]), record[6]));
                }
            }
            scan.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    //print File
    public void saveFile() {
        FileWriter f = null;
        try {
            f = new FileWriter(new File(USERDATA_FILE));
            for (User user : userList) {
                f.write(user.getNickname() + ";" + user.getNewGames() + ";" + user.getGamesSolved() + ";" + user.getGamesTriedNotSolved() + ";" + user.getNumberOfGamesSolved() + ";" + user.getNumberOfGamesTriedNotSolved() + ";" + user.getAvgTime() + "\n");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "\n" + ex.getStackTrace());
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage() + "\n" + ex.getStackTrace());
            }
        }
    }

    /*
    *
    * Getter and Setter for the Data
    *
     */
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String[] getNewSudokusArray() {
        return newSudokusArray;
    }

    public ArrayList<String> getNewSudokusIndex() {
        return newSudokus;
    }

    public void setNewSudokusIndex(String[] newSudokusArray) {
        for (int i = 1; i < newSudokusArray.length; i++) {
            newSudokus.add(newSudokusArray[i]);
        }
    }

    public ArrayList<String> getSolvedSudokusIndex() {
        return solvedSudokus;
    }

    public void setSolvedSudokusIndex(String[] solvedSudokusArray) {
        for (int i = 1; i < solvedSudokusArray.length; i++) {
            solvedSudokus.add(solvedSudokusArray[i]);
        }
    }

    public ArrayList<String> getTriedSudokusIndex() {
        return triedSudokus;
    }

    public void setTriedSudokusIndex(String[] triedSudokusArray) {
        for (int i = 1; i < triedSudokusArray.length; i++) {
            triedSudokus.add(triedSudokusArray[i]);
        }
    }

    public void setNewSudokusArray(String[] newSudokusArray) {
        this.newSudokusArray = newSudokusArray;
    }

    public String[] getSolvedSudokusArray() {
        return solvedSudokusArray;
    }

    public void setSolvedSudokusArray(String[] solvedSudokusArray) {
        this.solvedSudokusArray = solvedSudokusArray;
    }

    public String[] getTriedSudokusArray() {
        return triedSudokusArray;
    }

    public void setTriedSudokusArray(String[] triedSudokusArray) {
        this.triedSudokusArray = triedSudokusArray;

    }

    public int getNumberOfGamesSolved() {
        return numberOfGamesSolved;
    }

    public void setNumberOfGamesSolved(int numberOfGamesSolved) {
        this.numberOfGamesSolved = numberOfGamesSolved;
    }

    public int getNumberOfGamesTriedNotSolved() {
        return numberOfGamesTriedNotSolved;
    }

    public void setNumberOfGamesTriedNotSolved(int numberOfGamesTriedNotSolved) {
        this.numberOfGamesTriedNotSolved = numberOfGamesTriedNotSolved;
    }

    public String getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(String avgTime) {
        this.avgTime = avgTime;
    }

    ArrayList<User> setUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
