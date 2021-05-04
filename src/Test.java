import javax.swing.*;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getPath();
        }
    }
}
