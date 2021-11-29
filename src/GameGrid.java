import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class GameGrid extends JPanel implements Runnable, MouseListener, ComponentListener{

    private static final Color GOLDEN_YELLOW = new Color(255,204,0);
    private int cyclesPerSecond = 3;
    private boolean gameSimStatus = false;
    private Dimension gridSize = null;
    private ArrayList<Point> point = new ArrayList<>(0);
    private static final int CELL_SIZE = 20;
    
    public GameGrid(){
        addComponentListener(this);
        addMouseListener(this);
        setBackground(Color.BLACK);
    }

    public void updateCyclesPerSecond(int val){
        cyclesPerSecond = val;
    }

    public void setGameSimStatus(boolean status){
        gameSimStatus = status;
    }

    public void makeCellAlive(int x, int y){
        if (!point.contains(new Point(x,y))) {
            point.add(new Point(x,y));
        }
        else {
            makeCellDead(x, y);
        } 
        repaint();
    }

    public void makeCellAlive(MouseEvent e){
        int x = e.getPoint().x/CELL_SIZE-1;
        int y = e.getPoint().y/CELL_SIZE-1;
        if ((x >= 0) && (x < gridSize.width) && (y >= 0) && (y < gridSize.height)) {
            makeCellAlive(x,y);
        }
    }

    public void makeCellDead(int x, int y){
        point.remove(new Point(x,y));
    }

    public void eraseGrid(){
        point.clear();
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
    public void paintComponent(Graphics gr){
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
    public void componentResized(ComponentEvent e){
        gridSize = new Dimension(getWidth()/CELL_SIZE-2, (getHeight())/CELL_SIZE-2);
        updateGridSize();
    }

    @Override
    public void componentMoved(ComponentEvent e){
        // do nothing
    }

    @Override
    public void componentShown(ComponentEvent e){
        // do nothing
    }

    @Override
    public void componentHidden(ComponentEvent e){
        // do nothing
    }

    @Override
    public void mouseClicked(MouseEvent e){
        // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e){
        // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if(!gameSimStatus){
            makeCellAlive(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e){
        // do nothing
    }

    @Override
    public void run(){
        boolean[][] gameGrid = new boolean[gridSize.width+2][gridSize.height+2];
        for(Point current : point) {
            gameGrid[current.x+1][current.y+1] = true;
        }
        ArrayList<Point> aliveCells = new ArrayList<>(0);

        int[] neighborX = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] neighborY = { -1, 0, 1, -1, 1, -1, 0, 1 };
  
        for(int i=1; i<gameGrid.length-1; i++){
            for(int j=1; j<gameGrid[0].length-1; j++){
                int neighbors = 0;
                
                for(int k=0; k<neighborX.length; k++){
                    if (gameGrid[i+neighborX[k]][j+neighborY[k]]){
                        neighbors++;
                    }
                }
                if(gameGrid[i][j]){
                    if((neighbors == 2) || (neighbors == 3)){
                        aliveCells.add(new Point(i-1,j-1));
                    } 
                }else{
                    if(neighbors == 3){
                        aliveCells.add(new Point(i-1,j-1));
                    }
                }
            }
        }
        eraseGrid();
        point.addAll(aliveCells);
        repaint();
        try{
            Thread.sleep(1000/cyclesPerSecond);
            run();
        }catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}