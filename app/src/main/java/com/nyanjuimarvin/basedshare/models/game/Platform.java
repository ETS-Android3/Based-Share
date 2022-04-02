
package com.nyanjuimarvin.basedshare.models.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Platform {

    @SerializedName("platform")
    @Expose
    private Platform__1 platform;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    /**
     * 
     * @param platform
     */
    public Platform(Platform__1 platform) {
        super();
        this.platform = platform;
    }

    public Platform__1 getPlatform() {
        return platform;
    }

    public void setPlatform(Platform__1 platform) {
        this.platform = platform;
    }

}
