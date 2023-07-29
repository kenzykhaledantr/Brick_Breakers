/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.brick_breake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author KENZY
 */
public class Brick_breake extends JFrame{

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Start s = new Start();
        obj.setBounds(200, 5, 700, 700);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.getContentPane().setBackground(Color.WHITE);

// Create and customize the JLabel
        JLabel label = new JLabel("Brick Breaker");
        label.setFont(new Font("Arial", Font.BOLD, 48));
        label.setForeground(Color.BLUE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(0, 200, obj.getWidth(), 50);

// Add the JLabel to the content pane
        obj.getContentPane().setLayout(null);
        obj.getContentPane().add(label);

// Create and customize the JButton
        JButton b = new JButton("Start");
        b.setBounds(50, 100, 300, 30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setHorizontalAlignment(JButton.CENTER);
        b.setVerticalAlignment(JButton.CENTER);

// Add the JButton to the content pane
        obj.add(b);

// Set the location of the JButton
        b.setLocation((obj.getWidth() - b.getWidth()) / 2, (obj.getHeight() - b.getHeight()) / 2);

        obj.setVisible(true);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 obj.dispose();
                 new Start();

            }
        });

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
