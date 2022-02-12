package com.hangman.game.gui.frame;

import com.hangman.game.gui.panels.EmptyPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class HangmanFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final EmptyPanel emptyPanel;
    //will keep all our imported panels that will be added to main JFrame
    private JPanel mainPanel;

    public HangmanFrame(EmptyPanel emptyPanel) {
        this.emptyPanel = emptyPanel;
    }

    //it will be automatically invoked. Wew set the settings of the Frame of the app
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
        this.add(mainPanel);
        this.setVisible(true);
    }


}