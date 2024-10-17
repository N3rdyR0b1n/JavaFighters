package Menu;

import Creatures.BrawlerGuy;
import Creatures.GunGuy;
import Creatures.SwordGuy;
import GameStuff.Arena;
import GameStuff.Creature;
import GameStuff.Player;
import Item.Item;
import Item.Items;
import Util.FileUtil;
import Util.MenuInfo;
import Util.SoundUtil;
import Util.TextUtil;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMenuForm extends JFrame{
    private JButton settingsButton;
    private JPanel MenuPanel;
    private JButton leaveButton;
    private JButton playButton;
    private JLabel javaGameTitle;
    private JLabel creditName;
    private JButton creditsButton;


    public MainMenuForm() {
        super();
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

        playButton.addActionListener(e -> {
            buttonPressed();
            playButtonPressed(e);
        });
        settingsButton.addActionListener(e -> {
            buttonPressed();
            TestingFeaturesForm form = new TestingFeaturesForm();
            form.Load();
        });
        leaveButton.addActionListener(e -> {
            buttonPressed();
            leaveButtonPressed(e);
        });
        creditsButton.addActionListener(e -> {
            buttonPressed();

        });

    }

    private void leaveButtonPressed(ActionEvent e) {
        this.dispose();
    }

    private void playButtonPressed(ActionEvent e) {
        List<Creature> p1characters = new ArrayList<>();

        List<Creature> p2characters = new ArrayList<>();
        List<Item> p1inventory = new ArrayList<>();
        List<Item> p2inventory = new ArrayList<>();

        p1characters.add(new SwordGuy("john sword"));
        p1characters.add(new SwordGuy("jane sword"));
        p2characters.add(new SwordGuy("evil sword"));
        p1characters.add(new GunGuy("Big iron"));
        p2characters.add(new GunGuy("pew mcshootin"));
        p2characters.add(new BrawlerGuy("Tough guy"));

        Random random = new Random();
        int max = Items.getItemCount();
        for (int i = 0; i < 12; i++) {
            p1inventory.add(Items.getItem(random.nextInt(max)));
            p2inventory.add(Items.getItem(random.nextInt(max)));
        }

        Player player1 = new Player(p1characters, "Player_1", p1inventory);
        Player player2 = new Player(p2characters, "Player_2", p2inventory);


        Arena arena = new Arena(player1, player2);

        GameForm form = new GameForm(arena);
        form.load();



    }

    private void buttonPressed() {
        SoundUtil.BUTTON_CLICK.play();
    }

}
