
package com.nyanjuimarvin.basedshare.models.game;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

public class GamesResponse {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("user_platforms")
    @Expose
    private Boolean userPlatforms;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GamesResponse() {
    }

    /**
     * 
     * @param next
     * @param previous
     * @param count
     * @param userPlatforms
     * @param results
     */
    public GamesResponse(Integer count, String next, Object previous, List<Result> results, Boolean userPlatforms) {
        super();
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
        this.userPlatforms = userPlatforms;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Boolean getUserPlatforms() {
        return userPlatforms;
    }

    public void setUserPlatforms(Boolean userPlatforms) {
        this.userPlatforms = userPlatforms;
    }

}
