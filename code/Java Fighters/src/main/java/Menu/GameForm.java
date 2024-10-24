package Menu;

import GameStuff.*;
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
import java.util.concurrent.CompletableFuture;

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
    private JList<Ability> abilities;
    private volatile JScrollPane scrollPane;
    private JLabel roundLbl;
    private JList<Creature> targets;
    private JList actionlog;
    private List<JLabel> creatures;
    private DefaultListModel<Ability> jlistAbilities = new DefaultListModel<Ability>();
    private DefaultListModel<Creature> jlistTargets = new DefaultListModel<Creature>();
    private volatile DefaultListModel<String> text = new DefaultListModel<>();;
    private int currentCharacter = 0;

    private Timer timer = new Timer(50, this::tick);
    private int counter=0;

    private Arena arena;
    private JFrame mainform;

    public GameForm(Arena arena, JFrame form) {
        super();
        this.mainform = form;
        form.setVisible(false);
        abilities.setModel(jlistAbilities);
        targets.setModel(jlistTargets);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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


        arena.setTextOutput(text);
        actionlog.setModel(text);
        actionlog.setAutoscrolls(true);
        TextUtil.fontify(actionlog);
    }

    private void loadGameObjects() {
        updateCharacters();
        applyFonts();
        arena.getCreatures().get(0).onTurn(arena);
        roundLbl.setText("Round : " + arena.getRound());
        arena.start();
    }

    private void applyFonts() {
        ArrayList<Component> components = new ArrayList<>(20);
        components.add(fightButton);
        components.add(defendButton);
        components.add(actButton);
        components.add(spareButton);
        components.add(itemButton);
        components.add(mainPanel);
        components.add(abilities);
        components.addAll(creatures);
        components.add(targets);
        for (Component component : components) {
            TextUtil.fontify(component);
        }
        TextUtil.fontify(roundLbl, 2.5f);
    }

    public void updateCharacters() {
        arena.renderTick();
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
                Creature currentCreature = arena.getCreatures().get(currentCharacter);

                if(!currentCreature.isReady()) {
                    if (currentCreature.getSelectedAbility() == null) {
                        if(selectAbility(currentCreature)) {
                            if(currentCreature.getSelectedAbility().getTargets() > 0) {
                                loadTargets(currentCreature);
                            } else {
                                currentCreature.selectTarget(currentCreature);
                                proceedWithTurns(currentCreature);
                            }
                        }
                    } else {
                        selectTarget(currentCreature);
                        proceedWithTurns(currentCreature);
                    }
                } else {
                    proceedWithTurns(currentCreature);
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyUtil.PREV, 0), back);
        actionMap.put(back, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCharacter % 3 == 0) {
                    return;
                }
                List<Creature> creatures = arena.getCreatures();
                Creature oldcreature = creatures.get(currentCharacter);
                oldcreature.endTurn(arena);
                if (oldcreature.getSelectedAbility() instanceof Item) {
                    Player player = arena.getPlayer( currentCharacter < 3 ? 1 : 2);
                    player.getInventory().add(oldcreature.getSelectedAbility());
                }
                oldcreature.clearSelectedAbility();
                int current = currentCharacter;
                currentCharacter--;
                while (currentCharacter % 3 != 0) {
                    Creature creature = creatures.get(currentCharacter);
                    if (creature.alive()) {
                        break;
                    }
                    currentCharacter--;
                }
                if (currentCharacter < 0 || currentCharacter < 3 && current >= 3) {
                    currentCharacter = current;
                }

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
        jlistAbilities.clear();
        if (choices != null) {
            this.addAllAbilities(choices);
        }
    }

    private void loadInventory() {
        List<Ability> choices = arena.getRelevantItems(currentCharacter < 3);
        ArrayList<Ability> items = new ArrayList<Ability>(choices);
        jlistAbilities.clear();
        this.addAllAbilities(items);
    }

    private void loadTargets(Creature currentCreature) {
        Player opponent;
        if (currentCharacter < 3) {
            opponent = arena.getPlayer(2);
        } else {
            opponent = arena.getPlayer(1);
        }

        addAllTargets(opponent.getTeam());
    }

    private boolean selectAbility(Creature currentCreature) {
        if(abilities.isSelectionEmpty()){
            return false;
        }
        Ability selectedAbility = abilities.getSelectedValue();
        if (!selectedAbility.canPerform(arena, currentCreature)) {
            return false;
        }
        if (selectedAbility instanceof Item) {
            Player player = arena.getPlayer(currentCharacter < 3 ? 1 : 2);
            if (!player.getInventory().remove(selectedAbility)) {
                return false;
            }
        }
        currentCreature.setSelectedAbility(selectedAbility);

        return true;
    }

    private boolean selectTarget(Creature currentCreature) {
        Ability ability = currentCreature.getSelectedAbility();
        if (ability.getTargets() > 0 && targets.isSelectionEmpty()) {
            return false;
        }

        for (Creature target : targets.getSelectedValuesList()) {
            currentCreature.selectTarget(target);
        }
        jlistTargets.clear();
        return true;
    }

    private void proceedWithTurns(Creature currentCreature) {
        currentCreature.endTurn(arena);
        List<Creature> creatures = arena.getCreatures();

        currentCharacter++;
        if (currentCharacter >= creatures.size()) {
            currentCharacter=0;
            CompletableFuture.runAsync(() -> new TurnThread(arena, roundLbl).run());
        }
        Creature next = creatures.get(currentCharacter);
        while (!next.alive()) {
            currentCharacter++;
            if (currentCharacter >= creatures.size()) {
                currentCharacter=0;
                CompletableFuture.runAsync(() -> new TurnThread(arena, roundLbl).run());
            }
            next = creatures.get(currentCharacter);
        }
        creatures.get(currentCharacter).onTurn(arena);
        jlistAbilities.clear();
    }

    private <T extends Creature> void addAllTargets(List<T> list) {
        for (Creature target : list) {
            if (target.alive()) {
                jlistTargets.addElement(target);
            }
        }
    }

    private <T extends Ability> void addAllAbilities(List<T> list) {
        for (Ability ability : list) {
            jlistAbilities.addElement(ability);
        }
    }

    @Override
    public void dispose() {
        mainform.setVisible(true);
        super.dispose();
    }
}
