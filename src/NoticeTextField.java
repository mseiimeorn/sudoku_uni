
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
* set the Properties of the notice Textfiels
*
*/

/**
 *
 * @author Simon
 */
class NoticeTextField extends JTextField {
    private int heightNTF;
    
    public NoticeTextField() {
        heightNTF = 20;
        setPreferredSize(new Dimension(107, heightNTF));
        setFont(new Font("Calibri Light", Font.PLAIN, 14));
        setHorizontalAlignment((int) CENTER_ALIGNMENT);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                requestFocusInWindow();
                try {
                    setCaretPosition(TRAILING);
                } catch (Exception exc) {}
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                if (isEditable() == true) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    setCaretColor(Color.WHITE);
                    setSelectionColor(new Color(200, 200, 200));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEditable() == true) {
                    setSelectionEnd(0);
                    setBackground(Color.WHITE);
                    setCaretColor(Color.WHITE);
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((!(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (e.getKeyChar() == KeyEvent.VK_DELETE))) {
                    setText(getText() + " ");
                }
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    try {
                        setText(getText().substring(0, getText().length() - 1));
                    } catch (Exception exc){}
                }
                if (e.getKeyChar() == KeyEvent.VK_DELETE) {
                    setText("");
                }

            }
        });
    }
    
    public int getHeight(){
        return heightNTF;
    }
    
    public void setHeight(int heightNTF){
        this.heightNTF = heightNTF;
    }
}
