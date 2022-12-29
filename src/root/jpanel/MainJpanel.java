package root.jpanel;

import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.swing.FontIcon;
import root.http.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class MainJpanel extends JPanel {
    private Container container;
    private Server server;
    public MainJpanel( ) {
    setLayout(new BorderLayout());
    add(north(), BorderLayout.NORTH);
    }
    private JPanel north() {
        JPanel northPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(northPanel, BoxLayout.Y_AXIS);
        northPanel.setLayout(boxLayout);
        FontIcon fontIcon = FontIcon.of(Octicons.STAR_24,14);
        FontIcon fontIcon2 = FontIcon.of(Octicons.STOP_24,14);
        FontIcon fontIcon3 = FontIcon.of(Octicons.BELL_24,14);
        JPanel jPanelIcons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jButton = new JButton( fontIcon);
        JButton jButton2 = new JButton( fontIcon2);
        JButton jButton3 = new JButton( fontIcon3);
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // créer un tableau de string et le traiter pour chaque context dans la class server
                    String[] context = {"index","test", "toto"};
                      server = Server.createServer(8000,context);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                server.stopServer(0);
            }
        });

        jButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    server.reStart(0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanelIcons.add(jButton);
        jPanelIcons.add(jButton2);
        jPanelIcons.add(jButton3);
        northPanel.add(jPanelIcons);
        return northPanel;
    }

}
