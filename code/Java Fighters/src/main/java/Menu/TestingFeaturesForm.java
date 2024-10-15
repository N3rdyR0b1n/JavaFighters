package Menu;

import GameStuff.Ability;
import Item.Item;
import Item.Items;
import Util.MenuInfo;

import javax.swing.*;
import java.util.Random;

public class TestingFeaturesForm extends JFrame {
    private JScrollPane scrollpane;
    private JList testlist;
    private JPanel panel1;
    private DefaultListModel<Ability> list = new DefaultListModel<Ability>();

    public TestingFeaturesForm() {
        super();
        setTitle("Settings!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(500, 500);
    }

    public void Load() {
        setContentPane(panel1);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        testlist.setModel(list);

        Random random = new Random();
        int max = Items.getItemCount()-1;
        for (int i = 0; i < 100; i++) {
            //list.addElement(Items.getItem(random.nextInt(max)));
            list.addElement(new Item("adadad","f", 0,0));
        }
    }

}
