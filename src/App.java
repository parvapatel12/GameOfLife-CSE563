
import javax.swing.*;
public class App {
    public static void main(String[] args) {
        BaseGUI gameWindow = new BaseGUI();
        gameWindow.init();
        gameWindow.setSize(800, 800);
        gameWindow.setTitle("Game of Life -  Group 7 (CSE 563)");
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}