import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JPanel Library;
    private JComboBox dropDownMenu;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton loadFileButton;
    private JButton itemListingsButton;
    private JButton availableCopiesButton;
    private JButton saveFileButton;
    private DataManagerGUI dm;

    public GUI(String title) {
        super(title);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setContentPane(Library);
        this.pack();
        dm = new DataManagerGUI();
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.loadFile();
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new GUI("Library");
        frame.setVisible(true);
    }
}
