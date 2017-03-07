package com.habijabi.root.aswitch;

/**
 * Created by root on 18/2/17.
 */

public class ItemObject {
    private int screenShot;
    private String musicName;

    public ItemObject(int screenShot, String musicName, String musicAuthor) {
        this.screenShot = screenShot;
        this.musicName = musicName;
    }

    public int getScreenShot() {
        return screenShot;
    }

    public String getMusicName() {
        return musicName;
    }

}
