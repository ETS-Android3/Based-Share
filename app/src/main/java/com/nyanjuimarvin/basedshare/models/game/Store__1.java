
package com.nyanjuimarvin.basedshare.models.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store__1 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Store__1() {
    }

    /**
     * 
     * @param name
     * @param id
     * @param slug
     */
    public Store__1(Integer id, String name, String slug) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
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

}
