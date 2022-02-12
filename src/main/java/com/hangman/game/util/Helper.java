package com.hangman.game.util;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Objects;

@Component
public class Helper {

    public static final ImageIcon SMILE_IMG = new ImageIcon(Objects.requireNonNull(Helper.class.getClassLoader().getResource("images/smile.jpg")));
    public static final ImageIcon SAD_IMG = new ImageIcon(Objects.requireNonNull(Helper.class.getClassLoader().getResource("images/sad.jpg")));
}
