
package com.nyanjuimarvin.basedshare.models.games;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Rating {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("percent")
    @Expose
    private Double percent;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rating() {
    }

    /**
     * 
     * @param count
     * @param id
     * @param title
     * @param percent
     */
    public Rating(Integer id, String title, Integer count, Double percent) {
        super();
        this.id = id;
        this.title = title;
        this.count = count;
        this.percent = percent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

}
