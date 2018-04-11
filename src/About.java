/*
*
* Display About Section in OptionPane
*
*/

/**
 *
 * @author Simon
 */
public class About{
        
    public About() {
    }
    
    public String getAboutInformation(){
        String aboutInformation = "";
        
        aboutInformation += "Name:     " + "Simon" + "\n"; //15 Klassen
        aboutInformation += "SurName:   " + "Meier" + "\n\n"; //
        aboutInformation += "Faculty:   " + "Computer Science" + "\n";
        aboutInformation += "Place:   " + "FU Bolzano" + "\n\n";
        aboutInformation += "No. of classes:   " + "14" + "\n";
        aboutInformation += "No. of methods:   " + "128" + "\n";
        aboutInformation += "No. of lines of code:   " + "2327" + "\n";
        
        return aboutInformation;
    }
}