package Util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextUtil {
    public static File MinecraftFontFile = new File(FileUtil.FONTS + "/minecraft_font.ttf");
    public static Font MinecraftFont;
    static {
        try {
            MinecraftFont = Font.createFont(Font.TRUETYPE_FONT, MinecraftFontFile);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fontify(Component label, float multiplier) {
        label.setFont(MinecraftFont.deriveFont(label.getFont().getSize() * multiplier));
    }

    public static void fontify(Component label) {
        fontify(label, 1);
    }
}
