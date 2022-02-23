package com.hangman.game.gui.frame;

import com.hangman.game.gui.menu.Menu;
import com.hangman.game.gui.panels.EmptyPanel;
import com.hangman.game.gui.panels.ImagesPanel;
import com.hangman.game.gui.panels.LettersPanel;
import com.hangman.game.gui.panels.WordPanel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class HangmanFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private final EmptyPanel emptyPanel;
    private final ImagesPanel imagesPanel;
    private final LettersPanel lettersPanel;
    private final WordPanel wordPanel;
    private final Menu menu;
    //will keep all our imported panels that will be added to main JFrame
    private JPanel mainPanel;

    public HangmanFrame(EmptyPanel emptyPanel, ImagesPanel imagesPanel, LettersPanel lettersPanel, WordPanel wordPanel, Menu menu) {
        this.emptyPanel = emptyPanel;
        this.imagesPanel = imagesPanel;
        this.lettersPanel = lettersPanel;
        this.wordPanel = wordPanel;
        this.menu = menu;
    }

    //it will be automatically invoked after the HangmanFrame constructor is called.
    // We set the settings of the Frame of the app
    @PostConstruct
    public void createMainGUI() {
        this.setBounds(100, 70, 1100, 500);
        this.setResizable(false);
        //Listener to close the application
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());

        this.mainPanel.add(emptyPanel, BorderLayout.SOUTH);
        this.mainPanel.add(imagesPanel, BorderLayout.EAST);
        this.mainPanel.add(lettersPanel, BorderLayout.CENTER);
        this.mainPanel.add(wordPanel, BorderLayout.NORTH);

        this.add(mainPanel);
        this.setJMenuBar(menu);
        this.setVisible(true);
    }

    public void newGame() {
        this.dispose();
        int x = this.getX();
        int y = this.getY();
        this.clearPanels();
        this.setLocation(x, y);
        this.setVisible(true);
    }

    private void clearPanels() {
        this.lettersPanel.clear();
        this.wordPanel.clear();
        this.imagesPanel.clear();
    }

}
