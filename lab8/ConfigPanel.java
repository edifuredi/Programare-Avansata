/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

/**
 *
 * @author user
 */
import javax.swing.*;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel label;
    JTextField sizeField;
    JButton drawBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        label = new JLabel("Size:");
        sizeField = new JTextField("10", 5);
        drawBtn = new JButton("Draw");

        add(label);
        add(sizeField);
        add(drawBtn);

        drawBtn.addActionListener(e -> {
            int size = Integer.parseInt(sizeField.getText());
            frame.canvas.setSize(size);
        });
    }
}
