package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class GUI {
    JFrame jFrame = getJFrame();
    JPanel jPanel = new JPanel();

    public GUI(){
        jFrame.add(jPanel);

        JTextArea textArea = new JTextArea(10, 45);
        textArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(textArea);

        JLabel jLabel1 = new JLabel();
        jLabel1.setText("Введите числа");

        JTextArea jTextAreaOutput = new JTextArea(10, 45);
        JScrollPane jScrollPane1Output= new JScrollPane(jTextAreaOutput);

        JButton jButtonEnterMyQueue = new JButton("Enter MyQueue");
        jPanel.add(jButtonEnterMyQueue);
        jButtonEnterMyQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                MyQueue queue = Logic.splitMyQueue(text);
                queue = Logic.sortMyQueue(queue);

                String str = Logic.queueToString(queue);
                jTextAreaOutput.setText(str);
            }
        });

        JButton jButtonEnterQueue = new JButton("Enter Queue");
        jPanel.add(jButtonEnterQueue);
        jButtonEnterQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                java.util.Queue queue = Logic.splitQueue(text);
                queue = Logic.sortQueue(queue);
//                String[] strings = Logic.queueToArray(queue);
//                String str = Logic.arrayToString(strings);
                //jTextAreaOutput.setText(str);
            }
        });

        JButton jButtonFromFile = new JButton("Load from file");
        jPanel.add(jButtonFromFile);
        jButtonFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory( new File("src\\com\\company"));

                if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    try {
                        FileReader fr = new FileReader(jFileChooser.getSelectedFile());
                        Scanner scn = new Scanner(fr);
                        StringBuilder str = new StringBuilder();
                        while (scn.hasNextLine()){
                            str.append(scn.nextLine());
                        }
                        textArea.setText(String.valueOf(str));

                    } catch (Exception e){
                        System.out.println("Error: " + e);
                    }
                }
            }
        });

        JButton jButtonToFile = new JButton("Save into file");
        jPanel.add(jButtonToFile);
        jButtonToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                String result = jTextAreaOutput.getText();

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("src\\com\\company"));

                if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter fw = new FileWriter(jFileChooser.getSelectedFile())){
                        fw.write(text);
                        fw.write("\n");
                        fw.write(result);
                    }
                    catch (Exception e) {
                        System.out.println("Save file error");
                    }
                }

            }
        });

        jPanel.add(jScrollPane);
        jPanel.add(jLabel1);
        jPanel.add(jScrollPane1Output);
        jPanel.revalidate();
    }

    private JFrame getJFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(700, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}
