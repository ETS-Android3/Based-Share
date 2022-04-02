
package com.nyanjuimarvin.basedshare.models.games;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tag {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("games_count")
    @Expose
    private Integer gamesCount;
    @SerializedName("image_background")
    @Expose
    private String imageBackground;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tag() {
    }

    /**
     * 
     * @param name
     * @param imageBackground
     * @param language
     * @param id
     * @param slug
     * @param gamesCount
     */
    public Tag(Integer id, String name, String slug, String language, Integer gamesCount, String imageBackground) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.language = language;
        this.gamesCount = gamesCount;
        this.imageBackground = imageBackground;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

}
