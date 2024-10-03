package main.Menu;

import Arena;
import Creature;
import main.Item.Item;
import main.Item.Items;
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

    private Timer timer = new Timer(50, e -> tick(e));

    private Arena arena;

    public GameForm(Arena arena) {
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(MenuInfo.WIDTH, MenuInfo.HEIGHT);
        this.arena = arena;
        timer.start();
    }



    public void load() {

        items = new DefaultListModel<>();
        list1.setModel(items);
        ArrayList<Component> components = new ArrayList<>(20);
        components.add(fightButton);
        components.add(defendButton);
        components.add(actButton);
        components.add(spareButton);
        components.add(itemButton);
        components.add(mainPanel);
        components.add(list1);

        creatures = new ArrayList<>();
        creatures.add(creatureA1);
        creatures.add(creatureA2);
        creatures.add(creatureA3);
        creatures.add(creatureB1);
        creatures.add(creatureB2);
        creatures.add(creatureB3);

        for (Component component : components) {
            TextUtil.fontify(component);
        }
        String party = "Character : ";
        int i = 1;
        List<Creature> creatureList = arena.getCreatures();
        for (JLabel label : creatures) {
            Creature creature = creatureList.get(i-1);
            TextUtil.fontify(label);
            label.setText(party + i);
            label.setIcon(new ImageIcon(creature.getImageSource()));
            label.setText(creature.status());
            i++;
        }

        items.addElement(Items.APPLE.clone());
        items.addElement(Items.GOLDEN_APPLE.clone());
        items.addElement(Items.HEALING_POTION.clone());
        items.addElement(Items.GOLDEN_APPLE.clone());
        items.addElement(Items.TUNA_SALAD.clone());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Creature 1: haiii :3"));
        panel.add(new JLabel("Creature 2: woah check it out guys im the grungler!!!"));
        panel.add(new JLabel("Creature 3: KILL Y- [User has been muted for 5 minutes]"));
        panel.add(new JLabel("Creature 4: hiiiiii :3c"));
        panel.add(new JLabel("Creature 2: so sad your mom died of ligma"));
        panel.add(new JLabel("Creature 5: piss off"));
        panel.add(new JLabel("Creature 6: I too am in this episode"));
        panel.add(new JLabel("Creature 1: meow"));

        for (Component component : panel.getComponents()) {
            TextUtil.fontify(component);
        }
        scrollPane.setViewportView(panel);

    }



    private void tick(ActionEvent e) {

    }

}
