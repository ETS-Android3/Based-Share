
package com.nyanjuimarvin.basedshare.models.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ParentPlatform {

    @SerializedName("platform")
    @Expose
    private Platform__2 platform;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ParentPlatform() {
    }

    /**
     * 
     * @param platform
     */
    public ParentPlatform(Platform__2 platform) {
        super();
        this.platform = platform;
    }

    public Platform__2 getPlatform() {
        return platform;
    }

    public void setPlatform(Platform__2 platform) {
        this.platform = platform;
    }

}
