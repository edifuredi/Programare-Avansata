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
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel canvas;
    JPanel controlPanel;
    JButton createBtn, resetBtn, exitBtn, checkBtn, saveBtn, loadBtn, exportBtn;

    public MainFrame() {
        super("Maze");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);

        controlPanel = new JPanel();

        createBtn = new JButton("Create");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");
        checkBtn = new JButton("Check");
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");
        exportBtn = new JButton("Export PNG");

        controlPanel.add(createBtn);
        controlPanel.add(resetBtn);
        controlPanel.add(checkBtn);
        controlPanel.add(saveBtn);
        controlPanel.add(loadBtn);
        controlPanel.add(exportBtn);
        controlPanel.add(exitBtn);

        exitBtn.addActionListener(e -> System.exit(0));
        resetBtn.addActionListener(e -> canvas.reset());
        createBtn.addActionListener(e -> canvas.randomize());
        checkBtn.addActionListener(e -> canvas.check());
        saveBtn.addActionListener(e -> canvas.save());
        loadBtn.addActionListener(e -> canvas.load());
        exportBtn.addActionListener(e -> canvas.exportPNG());

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
}