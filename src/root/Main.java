package root;

import com.formdev.flatlaf.FlatLightLaf;
import root.Menu.MenuBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Main extends JFrame {
    private static Main m = new Main();

    public static void main(String[] args) throws IOException {
        m.launch();
       }

    private void launch() throws IOException {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("OptionPane.noButtonText", "Non");
            UIManager.put("OptionPane.yesButtonText", "Oui");
        } catch (Exception ex) {
            System.err.println("Failed to initialize UIManager");
        }
        m.setIconImage(ImageIO.read(getClass().getResource("/resources/images/france.png")));
        m.setJMenuBar(new MenuBar());
        m.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        m.setLocationRelativeTo(null);
        m.setSize(900, 700);
        m.setExtendedState(MAXIMIZED_BOTH);
        m.setVisible(true);
    }


}