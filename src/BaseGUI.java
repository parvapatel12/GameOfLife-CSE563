import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseGUI extends JFrame implements ActionListener {
    
    public void init() {
        // create container to hold GUI in window
        Container pane = this.getContentPane();
        pane.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        	//parse some data from input
            //do what we want to do with whatever data  
        }catch (NumberFormatException ex) {
            System.out.println("Exception: " + ex);
            JOptionPane.showMessageDialog(this, "Please enter a warning message");
        }catch (ArrayIndexOutOfBoundsException ex) {
            //errors
        }catch (NegativeArraySizeException ex) {
            //errors
        }
    }
}