package Util;

import Audio.SoundEvent;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundUtil {

    public static SoundEvent BUTTON_CLICK;

    public static void init() {
        BUTTON_CLICK = new SoundEvent("button_click.wav");

    }




}
