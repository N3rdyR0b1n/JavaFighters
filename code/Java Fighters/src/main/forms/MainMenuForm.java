package main.Menu;

import Arena;
import Creature;
import main.Creatures.BrawlerGuy;
import main.Creatures.GunGuy;
import main.Creatures.SwordGuy;
import Util.MenuInfo;
import Util.TextUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainMenuForm extends JFrame{
    private JButton settingsButton;
    private JPanel MenuPanel;
    private JButton leaveButton;
    private JButton playButton;
    private JLabel javaGameTitle;
    private JLabel creditName;
    private JButton creditsButton;


    public MainMenuForm() {
        setContentPane(MenuPanel);
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
        setVisible(true);
        setSize(MenuInfo.WIDTH, MenuInfo.HEIGHT);

        TextUtil.fontify(javaGameTitle, 4f);
        TextUtil.fontify(creditName, 1.5f);
        TextUtil.fontify(playButton, 3f);
        TextUtil.fontify(settingsButton, 3f);
        TextUtil.fontify(leaveButton, 3f);
        TextUtil.fontify(creditsButton, 3f);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonPressed(e);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leaveButtonPressed(e);
            }
        });
    }

    private void leaveButtonPressed(ActionEvent e) {
        this.dispose();
    }

    private void playButtonPressed(ActionEvent e) {
        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(new SwordGuy("john sword"));
        creatureList.add(new SwordGuy("jane sword"));
        creatureList.add(new SwordGuy("evil sword"));
        creatureList.add(new SwordGuy("bow guy"));
        creatureList.add(new GunGuy("pew mcshootin"));
        creatureList.add(new BrawlerGuy("guy"));
        Arena arena = new Arena(creatureList);

        GameForm form = new GameForm(arena);
        form.load();

    }



}
