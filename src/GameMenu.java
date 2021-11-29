import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel implements ActionListener, ChangeListener{
    public JButton bStart = new JButton("Start");
    public JButton bStop = new JButton("Stop");
    public JButton bErase = new JButton("Erase");
    transient SpinnerModel model = new SpinnerNumberModel(3, 1, 60, 1);     
    public JSpinner spinner = new JSpinner(model);
    private JLabel label = new JLabel("Speed (FPS)");

    private static final String BUTTON_FONT = "Tahoma"; 
    private static final Dimension BUTTON_SIZE = new Dimension(150, 50);
    private static final Dimension SPINNER_SIZE = new Dimension(50, 50);

    GameMenu(){
        setPreferredSize(new Dimension(10, 60));
        bStart.setBackground(Color.GREEN.darker());
        bStart.setPreferredSize(BUTTON_SIZE);
        bStart.setForeground(Color.WHITE);
        bStart.setFocusPainted(false);
        bStart.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        
        bStop.setForeground(Color.LIGHT_GRAY);
        bStop.setFocusPainted(false);
        bStop.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        bStop.setPreferredSize(BUTTON_SIZE);
        bStop.setEnabled(false);
        
        bErase.setBackground(Color.BLUE.darker());
        bErase.setForeground(Color.WHITE);
        bErase.setFocusPainted(false);
        bErase.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        bErase.setPreferredSize(BUTTON_SIZE);

        spinner.setFont(new Font(BUTTON_FONT, Font.BOLD, 18));
        spinner.setPreferredSize(SPINNER_SIZE);

        label.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 5));

        add(bStart);
        add(bStop);
        add(bErase);
        add(label);
        add(spinner,BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder(0, 50, 25, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // do nothing
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // do nothing
    }
}