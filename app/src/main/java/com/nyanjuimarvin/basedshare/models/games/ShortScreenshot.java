
package com.nyanjuimarvin.basedshare.models.games;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortScreenshot {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShortScreenshot() {
    }

    /**
     * 
     * @param image
     * @param id
     */
    public ShortScreenshot(Integer id, String image) {
        super();
        this.id = id;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
