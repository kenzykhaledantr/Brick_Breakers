package com.mycompany.brick_breake;

import javax.swing.*;
import java.awt.*;

public class Start extends JPanel {
    public Start(){
            JFrame obj = new JFrame();
            GamePlay gamePlay = new GamePlay();
            obj.setBounds(200, 5, 700, 600);
            obj.setTitle("Brick Breaker");
            obj.setResizable(false);
            obj.getContentPane().setBackground(Color.LIGHT_GRAY);
            obj.setVisible(true);
            obj.add(gamePlay);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }

