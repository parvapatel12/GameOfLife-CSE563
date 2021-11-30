import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class GameGrid extends JPanel implements Runnable, MouseListener, ComponentListener {

    private static final Color GOLDEN_YELLOW = new Color(255,204,0);
    private int cyclesPerSecond = 3;
    private boolean gameSimStatus = false;
    private Dimension gridSize = null;
    private ArrayList<Point> point = new ArrayList<>(0);
    private static final int CELL_SIZE = 20;

    public GameGrid() {
        addComponentListener(this);
        addMouseListener(this);
        setBackground(Color.lightGray);
    }

    public void updateGridSize(){
        ArrayList<Point> removeList = new ArrayList<>(0);
        for (Point current : point) {
            if ((current.x > gridSize.width-1) || (current.y > gridSize.height-1)) {
                removeList.add(current);
            }
        }
        point.removeAll(removeList);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        try {
            for (Point newPoint : point){
                gr.setColor(GOLDEN_YELLOW);
                gr.fillRect(CELL_SIZE + (CELL_SIZE*newPoint.x), CELL_SIZE + (CELL_SIZE*newPoint.y), CELL_SIZE, CELL_SIZE);
            }
        } catch (ConcurrentModificationException cme){
            //do nothing
        }

        gr.setColor(Color.WHITE);
        for (int i=0; i<=gridSize.width; i++){
            gr.drawLine(((i*CELL_SIZE)+CELL_SIZE), CELL_SIZE, (i*CELL_SIZE)+CELL_SIZE, CELL_SIZE + (CELL_SIZE*gridSize.height));
        }
        for (int i=0; i<=gridSize.height; i++){
            gr.drawLine(CELL_SIZE, ((i*CELL_SIZE)+CELL_SIZE), CELL_SIZE*(gridSize.width+1), ((i*CELL_SIZE)+CELL_SIZE));
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        gridSize = new Dimension(getWidth()/CELL_SIZE-2, (getHeight())/CELL_SIZE-2);
        updateGridSize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}
