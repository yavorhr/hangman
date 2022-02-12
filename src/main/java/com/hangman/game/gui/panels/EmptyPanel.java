package com.hangman.game.gui.panels;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class EmptyPanel extends JPanel {

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    public EmptyPanel(){
        this.setPreferredSize(new Dimension(500,100));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(2,1));
    }

}
