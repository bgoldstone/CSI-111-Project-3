import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Uses a tabbed interface with mostly JFrame, some JOptionsPane, and JFileChooser to manage a library and display a library's inventory.
 */
public class TabbedGUI extends JFrame {
    private JPanel panelTabbed;
    private JRootPane rootPane;
    private JTabbedPane library;
    private JTabbedPane itemListings;
    private JTextField checkOutIDBox;
    private JButton checkOutOkButton;
    private JButton checkInOkButton;
    private JTextField checkInIDBox;
    private JFormattedTextField booksTextField;
    private JPanel booksTab;
    private JFormattedTextField musicTextField;
    private JPanel musicTab;
    private JPanel moviesTab;
    private JFormattedTextField moviesTextField;
    private JTextField copiesIDBox;
    private JPanel checkIn;
    private JButton copiesOkButton;
    private JTextPane numberOfCopiesTextField;
    private JButton loadFileButton;
    private JButton saveFileButton;
    private JPanel checkOut;
    private JPanel copies;
    private JPanel loadSaveFile;
    private JTextArea moviesTextBox;
    private JTextArea musicTextBox;
    private JTextArea booksTextBox;
    private DataManagerTabbedGUI dm;

    public TabbedGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setContentPane(panelTabbed);
        this.pack();
        dm = new DataManagerTabbedGUI();
        //Sets size
        this.setSize(new Dimension(800, 500));
        //Basically centers on screen
        this.setLocationRelativeTo(null);

        //Check Out
        checkOutOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dm.setId(Integer.parseInt(checkOutIDBox.getText()));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid number! Please enter an integer!", "", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (NullPointerException ignored) {
                }
                try {
                    dm.checkOut();
                } catch (NullPointerException ignored) {
                }
            }
        });

        //Check in
        checkInOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dm.setId(Integer.parseInt(checkInIDBox.getText()));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid number! Please enter an integer!", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    dm.checkIn();
                } catch (NullPointerException ignored) {
                }
            }
        });


        //Books Tab
        booksTextBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                booksTextBox.setText(dm.getItemType("books"));
            }
        });

        //Music Tab
        musicTextBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                musicTextBox.setText(dm.getItemType("music"));
            }
        });

        //Movies Tab
        moviesTextBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                moviesTextBox.setText(dm.getItemType("movies"));
            }
        });

        //Copies Tab
        copiesOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dm.setId(Integer.parseInt(copiesIDBox.getText()));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid number! Please enter an integer!", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    numberOfCopiesTextField.setText(dm.getNumberOfCopies());
                } catch (NullPointerException ignored) {
                }
            }
        });

        //Save Button
        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.saveFile();
            }
        });

        //Load Button
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.loadFile();
            }
        });

        //Enter default hits ok
        checkOutIDBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                checkOutIDBox.setText("");
                rootPane = SwingUtilities.getRootPane(checkOutOkButton);
                rootPane.setDefaultButton(checkOutOkButton);
            }
        });

        //Enter default hits ok
        checkInIDBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                checkInIDBox.setText("");
                rootPane = SwingUtilities.getRootPane(checkInOkButton);
                rootPane.setDefaultButton(checkInOkButton);
            }
        });

        //Enter default hits ok
        copiesIDBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                copiesIDBox.setText("");
                rootPane = SwingUtilities.getRootPane(copiesOkButton);
                rootPane.setDefaultButton(copiesOkButton);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new TabbedGUI("Library");
        frame.setVisible(true);
    }

}
