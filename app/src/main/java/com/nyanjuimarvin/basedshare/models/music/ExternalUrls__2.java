
package com.nyanjuimarvin.basedshare.models.music;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ExternalUrls__2 {

    @SerializedName("spotify")
    @Expose
    private String spotify;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExternalUrls__2() {
    }

    /**
     * 
     * @param spotify
     */
    public ExternalUrls__2(String spotify) {
        super();
        this.spotify = spotify;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

}
