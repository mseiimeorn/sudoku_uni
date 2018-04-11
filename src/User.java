
/**
 *
 * @author Simon
 */
public class User {

    private int indexOfUser;
    private String nickname;
    private String newGames;
    private String gamesSolved;
    private String gamesTriedNotSolved;
    private int numberOfGamesSolved;
    private int numberOfGamesTriedNotSolved;
    private String avgTime;

    /**
     *
     * @param nickname Nickname of User
     * @param newGames Games User hasn't done yet
     * @param gamesSolved Games User solved
     * @param gamesTriedNotSolved Games User tried but didn't solve
     * @param numberOfGamesSolved Number of Games User solved
     * @param numberOfGamesTriedNotSolved Number of Games User tried but didn't solve
     * @param avgTime Average Time User needed for solved Games
     */
    public User(String nickname, String newGames, String gamesSolved, String gamesTriedNotSolved, int numberOfGamesSolved, int numberOfGamesTriedNotSolved, String avgTime) { //
        this.nickname = nickname;
        this.avgTime = avgTime;
        this.gamesSolved = gamesSolved;
        this.gamesTriedNotSolved = gamesTriedNotSolved;
        this.numberOfGamesSolved = numberOfGamesSolved;
        this.numberOfGamesTriedNotSolved = numberOfGamesTriedNotSolved;
        this.newGames = newGames;
    }
    
    /*
    *
    * Getters and Setters
    *
    */

    public String getNewGames() {
        return newGames;
    }

    public void setNewGames(String newGames) {
        this.newGames = newGames;
    }

    public int getIndexOfUser() {
        return indexOfUser;
    }

    public void setIndexOfUser(int indexOfUser) {
        this.indexOfUser = indexOfUser;
    }

    public String getGamesSolved() {
        return gamesSolved;
    }

    public void setGamesSolved(String gamesSolved) {
        this.gamesSolved = gamesSolved;
    }

    public String getGamesTriedNotSolved() {
        return gamesTriedNotSolved;
    }

    public void setGamesTriedNotSolved(String gamesTriedNotSolved) {
        this.gamesTriedNotSolved = gamesTriedNotSolved;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
