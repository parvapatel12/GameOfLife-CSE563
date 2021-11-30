import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseGUI extends JFrame implements ActionListener {

    private GameGrid gameGrid = new GameGrid();
    private GameMenu gameMenu = new GameMenu();
    
    public void init() {
        // create container to hold GUI in window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2) - 400;
        int y = (int) ((dimension.getHeight() - getHeight()) / 2) - 400;
        setLocation(x, y);

        this.setLayout(new BorderLayout());
        this.add(gameGrid, BorderLayout.CENTER);
        this.add(gameMenu, BorderLayout.SOUTH);

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