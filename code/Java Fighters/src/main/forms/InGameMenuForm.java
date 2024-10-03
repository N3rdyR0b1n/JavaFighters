package main.Menu;

import Util.MenuInfo;

import javax.swing.*;

public class InGameMenuForm extends JFrame{
    private JPanel mainPanel;
    private JPanel FightPanel;
    private JPanel ButtonPannel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JList list1;
    private JTextPane textPane1;

    public InGameMenuForm() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(MenuInfo.WIDTH, MenuInfo.HEIGHT);
    }
}
