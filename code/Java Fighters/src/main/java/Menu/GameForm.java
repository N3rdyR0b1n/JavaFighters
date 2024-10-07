package Menu;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Item.Item;
import Util.KeyUtil;
import Util.MenuInfo;
import Util.TextUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private DefaultListModel<Ability> jlist = new DefaultListModel<Ability>();
    private int currentCharacter = 0;

    private Timer timer = new Timer(50, this::tick);

    private Arena arena;

    public GameForm(Arena arena) {
        super();
        list1.setModel(jlist);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(MenuInfo.WIDTH, MenuInfo.HEIGHT);
        timer.start();
        this.arena = arena;
        loadElements();


        setVisible(true);

    }

    private void tick(ActionEvent e) {
        updateCharacters();
    }


    public void load() {
        loadGameObjects();
        keyBindingInit();
    }

    private void loadElements() {
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
        arena.getCreatures().get(0).onTurn(arena);
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






    public void keyBindingInit() {
        JPanel contentPane = (JPanel) this.getContentPane();
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = contentPane.getInputMap(condition);
        ActionMap actionMap = contentPane.getActionMap();
        String next = "next";
        String back = "back";
        inputMap.put(KeyStroke.getKeyStroke(KeyUtil.ENTER_KEY, 0), next);
        actionMap.put(next, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arena.getCreatures().get(currentCharacter).endTurn(arena);
                currentCharacter++;
                if (currentCharacter >= creatures.size()) {
                    currentCharacter=0;
                }
                arena.getCreatures().get(currentCharacter).onTurn(arena);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyUtil.PREV, 0), back);
        actionMap.put(back, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCharacter % 3 == 0) {
                    return;
                }
                arena.getCreatures().get(currentCharacter).endTurn(arena);
                currentCharacter--;
                if (currentCharacter < 0) {
                    currentCharacter= arena.getCreatures().size()-1;
                }
                arena.getCreatures().get(currentCharacter).onTurn(arena);
            }
        });

        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButtonOption(0);
            }
        });
        actButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButtonOption(1);
            }
        });
        spareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButtonOption(2);
            }
        });
        defendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButtonOption(3);
            }
        });
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadInventory();
            }
        });
    }

    private void loadButtonOption(int optionType) {
        List<Ability> choices = arena.getCreatures().get(currentCharacter).getByType(optionType);
        jlist.clear();
        if (choices != null) {
            addAll(choices);
        }
    }
    private void loadInventory() {
        List<Item> choices = arena.getRelevantItems(currentCharacter < 3);
        ArrayList<Ability> items = new ArrayList<Ability>(choices);
        jlist.clear();
        if (choices != null) {
            addAll(choices);
        }
    }
    private <T extends Ability> void addAll(List<T> list) {
        for (Ability ability : list) {
            jlist.addElement(ability);
        }
    }

}
