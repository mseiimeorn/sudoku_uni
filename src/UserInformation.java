/*
*
* Display user Information in OptionPane
*
*/

/**
 *
 * @author Simon
 */
public class UserInformation{
    private UserData userdata = new UserData();
    private User user;
    
    public UserInformation(int indexOfUser) {
        user = userdata.getUserList().get(indexOfUser);
    }
    
    public String getUserInformation(){
        String userInformation = "";
                
        userInformation += "Solved Games:     " + user.getNumberOfGamesSolved() + "\n\n";
        userInformation += "Unsolved Games:   " + user.getNumberOfGamesTriedNotSolved() + "\n\n";
        userInformation += "Average Time:     " + user.getAvgTime() + "\n\n";
        
        return userInformation;
    }
}
