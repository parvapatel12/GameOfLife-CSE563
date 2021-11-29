
import javax.swing.*;
public class App {
    public static void main(String[] args) {
        
    	// make window object
        BaseGUI GUI = new BaseGUI();
        GUI.init(); // init all our things!

        // set window object size
        GUI.setSize(800, 800);
        GUI.setTitle("Game of Life -  Group 7 (CSE 563)");
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}