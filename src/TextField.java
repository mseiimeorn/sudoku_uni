
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/*
*
* Class for Building the TextField
*
*/

/**
 *
 * @author Simon
 */
public class TextField extends JTextField {
    
    public TextField() {
        setPreferredSize(new Dimension(107, 87));
        setFont(new Font("Calibri Light", Font.ITALIC, 50));
        setBorder(BorderFactory.createEmptyBorder());
        setHorizontalAlignment((int) CENTER_ALIGNMENT);
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                if(isEditable() == true){
                    requestFocusInWindow();
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    setBackground(new Color(222, 100, 100));
                    setCaretColor(new Color(222, 100, 100));
                    selectAll();
                    setSelectionColor(new Color(222, 100, 100));
                }   
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(isEditable() == true){
                    setSelectionEnd(0);
                    setBackground(Color.WHITE);
                    setCaretColor(Color.WHITE);
                }
            }
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
                    e.consume();
                }
                selectAll();
                setSelectionColor(new Color(222, 100, 100));
            }
        });
    }
}
