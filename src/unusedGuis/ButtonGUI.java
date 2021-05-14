import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Uses a button interface with mostly JOptionsPane and some JFrame to manage a library and display a library's inventory.
 */
public class ButtonGUI extends JFrame {
    private JPanel panelButton;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton loadFileButton;
    private JButton itemListingsButton;
    private JButton availableCopiesButton;
    private JButton saveFileButton;
    private JButton exitButton;
    private DataManagerButtonGUI dm;

    public ButtonGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setContentPane(panelButton);
        this.pack();
        dm = new DataManagerButtonGUI();

        //Sets size
        panelButton.setPreferredSize(new Dimension(500, 500));

        //Basically centers on screen
        this.setLocationRelativeTo(null);
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.loadFile();
            }
        });
        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.saveFile();
            }
        });
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.checkOut();
            }
        });
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.checkIn();
            }
        });
        availableCopiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.getNumberOfCopies();
            }
        });
        itemListingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.getItemType();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Thanks for visiting the library!");
                exit();
            }
        });
    }
    private void exit(){
        try {
            Thread.sleep(250);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new ButtonGUI("Library");
        frame.setVisible(true);
    }
}
