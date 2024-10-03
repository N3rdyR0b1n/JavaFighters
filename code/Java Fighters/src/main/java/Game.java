import Item.Items;
import Menu.MainMenuForm;
import Util.MenuInfo;

import java.util.logging.Logger;

public class Game {



    public static void main(String[] args) {
        new Game().run();
    }

    public Game() {
        Items.init();


    }

    public void run() {
        MenuInfo.init();
        System.out.println(":3");
        MainMenuForm form = new MainMenuForm();


    }






}
