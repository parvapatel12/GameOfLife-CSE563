import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseGUI extends JFrame implements ActionListener, ChangeListener {

    transient Thread game;
    private GameGrid gameGrid = new GameGrid();
    private GameMenu gameMenu = new GameMenu();
    
    public void init() {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2) - 400;
        int y = (int) ((dimension.getHeight() - getHeight()) / 2) - 400;
        setLocation(x, y);

        gameMenu.bStart.addActionListener(this);
        gameMenu.bStop.addActionListener(this);
        gameMenu.bErase.addActionListener(this);
        gameMenu.spinner.addChangeListener(this);

        this.setLayout(new BorderLayout());
        this.add(gameGrid, BorderLayout.CENTER);
        this.add(gameMenu, BorderLayout.SOUTH);
    }

    public void setSimRunning(boolean isSimRunning) {
        gameGrid.setGameSimStatus(isSimRunning);
        gameMenu.bStart.setEnabled(!isSimRunning);
        gameMenu.bStop.setEnabled(isSimRunning);
        if(isSimRunning){
            gameMenu.bStart.setBackground(Color.WHITE);
            gameMenu.bStart.setForeground(Color.LIGHT_GRAY);
            gameMenu.bErase.setBackground(Color.WHITE);
            gameMenu.bErase.setForeground(Color.LIGHT_GRAY);
            gameMenu.bStop.setBackground(Color.RED.darker());
            gameMenu.bStop.setForeground(Color.WHITE);
            game = new Thread(gameGrid);
            game.start();
        }else{
            gameMenu.bStart.setBackground(Color.green.darker());
            gameMenu.bStart.setForeground(Color.WHITE);
            gameMenu.bErase.setBackground(Color.BLUE.darker());
            gameMenu.bErase.setForeground(Color.WHITE);
            gameMenu.bStop.setBackground(Color.WHITE);
            gameMenu.bStop.setForeground(Color.LIGHT_GRAY);
            game.interrupt();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource().equals(gameMenu.spinner)) {
            gameGrid.updateCyclesPerSecond((int)gameMenu.spinner.getValue());
        }   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(gameMenu.bErase)){
            gameGrid.eraseGrid();
            gameGrid.repaint();
        }else if(e.getSource().equals(gameMenu.bStart)) {
            setSimRunning(true);
        }else if(e.getSource().equals(gameMenu.bStop)) {
            setSimRunning(false);
        }
    }
}