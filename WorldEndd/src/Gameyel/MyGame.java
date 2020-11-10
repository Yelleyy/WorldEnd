package Gameyel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyGame {

    public static void main(String[] args) {
        JFrame jf = new PlayGames();
        jf.setSize(1200, 700);
        jf.setTitle(" WORLD END ");
        jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setFocusableWindowState(true);
        jf.setLocationRelativeTo(null);
    }
}
