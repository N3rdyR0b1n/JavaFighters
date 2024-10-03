package Util;

import java.awt.*;

public class MenuInfo {
    public static int WIDTH;
    public static int HEIGHT;
    public static int X;
    public static int Y;

    public static void init() {
        Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) dimensions.getWidth();
        HEIGHT = (int) dimensions.getHeight();

        X = WIDTH / 2;
        Y = HEIGHT / 2;
        System.out.println(WIDTH + " " + HEIGHT);
    }

}
