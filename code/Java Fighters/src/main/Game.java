import main.Menu.MainMenuForm;
import Util.MenuInfo;

public class Game {



    public static void main(String[] args) {
        new Game().run();
    }

    public Game() {
    }

    public void run() {
        MenuInfo.init();
        MainMenuForm form = new MainMenuForm();


    }






}
