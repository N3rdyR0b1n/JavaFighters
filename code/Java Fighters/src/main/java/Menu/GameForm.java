package Menu;

import GameStuff.Arena;
import GameStuff.Creature;
import Item.Item;
import Item.Items;
import Util.MenuInfo;
import Util.TextUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameForm extends JFrame {

    private JPanel mainPanel;
    private JLabel creatureA1;
    private JLabel creatureA2;
    private JLabel creatureA3;
    private JLabel creatureB1;
    private JLabel creatureB2;
    private JLabel creatureB3;
    private JButton fightButton;
    private JButton defendButton;
    private JButton actButton;
    private JButton spareButton;
    private JButton itemButton;
    private JList list1;
    private JScrollPane scrollPane;
    private List<JLabel> creatures;
    private DefaultListModel<Item> items;

    private Timer timer = new Timer(50, this::tick);

    private Arena arena;

    public GameForm(Arena arena) {
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(MenuInfo.WIDTH, MenuInfo.HEIGHT);
        timer.start();
        this.arena = arena;
        setVisible(true);

    }

    private void tick(ActionEvent e) {

    }


    public void load() {
        loadElements();
        loadGameObjects();
    }

    private void loadElements() {
        items = new DefaultListModel<>();
        list1.setModel(items);
        creatures = new ArrayList<>();
        creatures.add(creatureA1);
        creatures.add(creatureA2);
        creatures.add(creatureA3);
        creatures.add(creatureB1);
        creatures.add(creatureB2);
        creatures.add(creatureB3);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(panel);
        for (Component component : panel.getComponents()) {
            TextUtil.fontify(component);
        }
    }
    private void loadGameObjects() {
        updateCharacters();
        applyFonts();
    }

    private void applyFonts() {
        ArrayList<Component> components = new ArrayList<>(20);
        components.add(fightButton);
        components.add(defendButton);
        components.add(actButton);
        components.add(spareButton);
        components.add(itemButton);
        components.add(mainPanel);
        components.add(list1);
        components.addAll(creatures);
        for (Component component : components) {
            TextUtil.fontify(component);
        }
    }

    public void updateCharacters() {
        List<Creature> creatureList = arena.getCreatures();
        int i = 0;
        for (JLabel label : creatures) {
            Creature creature = creatureList.get(i);
            label.setText(creature.status());
            label.setIcon(new ImageIcon(creature.getImageSource()));
            i++;
        }
    }


}
