package root.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu jMenu = new JMenu("Fichier");
        jMenu.setMnemonic('F');
        JMenuItem jMenuItemNouveauFichier = new JMenuItem("Nouveau fichier...");
        jMenuItemNouveauFichier.setMnemonic('N');
        jMenu.add(jMenuItemNouveauFichier);
        jMenu.addSeparator();

        JMenuItem jMenuItemOuvrirFichier = new JMenuItem("Ouvrir fichier...");
        jMenuItemOuvrirFichier.setMnemonic('O');
        jMenuItemOuvrirFichier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem jMenuItemCloseWindow = new JMenuItem("Quitter");
        jMenuItemCloseWindow.setMnemonic('Q');
        jMenuItemCloseWindow.addActionListener((e) -> System.exit(0));

        jMenu.add(jMenuItemOuvrirFichier);
        jMenu.add(jMenuItemCloseWindow);
        this.add(jMenu);
    }
}
