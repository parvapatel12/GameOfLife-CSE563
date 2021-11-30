import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel implements ActionListener, ChangeListener{
    public JButton startBtn = new JButton("Start");
    public JButton stopBtn = new JButton("Stop");
    public JButton eraseBtn = new JButton("Erase");
    transient SpinnerModel model = new SpinnerNumberModel(3, 1, 60, 1);
    public JSpinner spinner = new JSpinner(model);
    private JLabel label = new JLabel("Speed (FPS)");

    private static final String BUTTON_FONT = "Tahoma";
    private static final Color BUTTON_COLOR = Color.black;
    private static final Dimension BUTTON_SIZE = new Dimension(150, 50);
    private static final Dimension SPINNER_SIZE = new Dimension(50, 50);

    GameMenu(){
        setPreferredSize(new Dimension(10, 60));
        startBtn.setBackground(Color.GREEN.darker());
        startBtn.setPreferredSize(BUTTON_SIZE);
        startBtn.setFocusPainted(false);
        startBtn.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        startBtn.setForeground(BUTTON_COLOR);

        stopBtn.setFocusPainted(false);
        stopBtn.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        stopBtn.setForeground(BUTTON_COLOR);
        stopBtn.setPreferredSize(BUTTON_SIZE);
        stopBtn.setEnabled(false);

        eraseBtn.setBackground(Color.BLUE.darker());
        eraseBtn.setFocusPainted(false);
        eraseBtn.setFont(new Font(BUTTON_FONT, Font.BOLD, 12));
        eraseBtn.setForeground(BUTTON_COLOR);
        eraseBtn.setPreferredSize(BUTTON_SIZE);

        spinner.setFont(new Font(BUTTON_FONT, Font.BOLD, 18));
        spinner.setPreferredSize(SPINNER_SIZE);

        label.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 5));

        add(startBtn);
        add(stopBtn);
        add(eraseBtn);
        add(label);
        add(spinner,BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder(0, 50, 25, 50));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
