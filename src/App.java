
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        BaseGUI appWindow = new BaseGUI();
        appWindow.init(); 
        appWindow.setSize(800, 800);
        appWindow.setTitle("Game of Life -  Group 7 (CSE 563)");
        appWindow.setVisible(true);
        appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}