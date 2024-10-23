package Util;

import Audio.SoundEvent;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class SoundUtil {

    public static SoundEvent BUTTON_CLICK;

    public static void init() {
        BUTTON_CLICK = new SoundEvent("button_click.wav");






    }




}
