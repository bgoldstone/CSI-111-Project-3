import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGUI extends JFrame {
    private JPanel panel;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton loadFileButton;
    private JButton itemListingsButton;
    private JButton availableCopiesButton;
    private JButton saveFileButton;
    private DataManagerGUI dm;

    public ButtonGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        dm = new DataManagerGUI();

        //Sets size
        panel.setPreferredSize(new Dimension(500, 500));

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
    }

    public static void main(String[] args) {
        JFrame frame = new ButtonGUI("Library");
        frame.setVisible(true);
    }

    public static class TabbedGUI extends JFrame {
        private JPanel panel;
        private JButton checkOutButton;
        private JButton checkInButton;
        private JButton loadFileButton;
        private JButton itemListingsButton;
        private JButton availableCopiesButton;
        private JButton saveFileButton;
        private DataManagerGUI dm;

        public TabbedGUI(String title) {
            super(title);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.setContentPane(panel);
            this.pack();
            dm = new DataManagerGUI();

            //Sets size
            panel.setPreferredSize(new Dimension(500, 500));

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
        }

        public static void main(String[] args) {
            JFrame frame = new TabbedGUI("Library");
            frame.setVisible(true);
        }
    }
}
