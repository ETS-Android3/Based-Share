
package com.nyanjuimarvin.basedshare.models.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddedByStatus {

    @SerializedName("yet")
    @Expose
    private Integer yet;
    @SerializedName("owned")
    @Expose
    private Integer owned;
    @SerializedName("beaten")
    @Expose
    private Integer beaten;
    @SerializedName("toplay")
    @Expose
    private Integer toplay;
    @SerializedName("dropped")
    @Expose
    private Integer dropped;
    @SerializedName("playing")
    @Expose
    private Integer playing;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddedByStatus() {
    }

    /**
     * 
     * @param owned
     * @param beaten
     * @param dropped
     * @param yet
     * @param playing
     * @param toplay
     */
    public AddedByStatus(Integer yet, Integer owned, Integer beaten, Integer toplay, Integer dropped, Integer playing) {
        super();
        this.yet = yet;
        this.owned = owned;
        this.beaten = beaten;
        this.toplay = toplay;
        this.dropped = dropped;
        this.playing = playing;
    }

    public Integer getYet() {
        return yet;
    }

    public void setYet(Integer yet) {
        this.yet = yet;
    }

    public Integer getOwned() {
        return owned;
    }

    public void setOwned(Integer owned) {
        this.owned = owned;
    }

    public Integer getBeaten() {
        return beaten;
    }

    public void setBeaten(Integer beaten) {
        this.beaten = beaten;
    }

    public Integer getToplay() {
        return toplay;
    }

    public void setToplay(Integer toplay) {
        this.toplay = toplay;
    }

    public Integer getDropped() {
        return dropped;
    }

    public void setDropped(Integer dropped) {
        this.dropped = dropped;
    }

    public Integer getPlaying() {
        return playing;
    }

    public void setPlaying(Integer playing) {
        this.playing = playing;
    }

}
