package com.habijabi.root.aswitch;

/**
 * Created by root on 18/2/17.
 */

public class ItemObject {
    private int screenShot;
    private String musicName;
    private String musicAuthor;

    public ItemObject(int screenShot, String musicName, String musicAuthor) {
        this.screenShot = screenShot;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
    }

    public int getScreenShot() {
        return screenShot;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

}
