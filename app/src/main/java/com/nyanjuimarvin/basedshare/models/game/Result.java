
package com.nyanjuimarvin.basedshare.models.game;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Result {

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playtime")
    @Expose
    private Integer playtime;
    @SerializedName("platforms")
    @Expose
    private List<Platform> platforms = null;
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("tba")
    @Expose
    private Boolean tba;
    @SerializedName("background_image")
    @Expose
    private String backgroundImage;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_top")
    @Expose
    private Integer ratingTop;
    @SerializedName("ratings")
    @Expose
    private List<Rating> ratings = null;
    @SerializedName("ratings_count")
    @Expose
    private Integer ratingsCount;
    @SerializedName("reviews_text_count")
    @Expose
    private Integer reviewsTextCount;
    @SerializedName("added")
    @Expose
    private Integer added;
    @SerializedName("added_by_status")
    @Expose
    private AddedByStatus addedByStatus;
    @SerializedName("metacritic")
    @Expose
    private Integer metacritic;
    @SerializedName("suggestions_count")
    @Expose
    private Integer suggestionsCount;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("esrb_rating")
    @Expose
    private EsrbRating esrbRating;

    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("saturated_color")
    @Expose
    private String saturatedColor;
    @SerializedName("dominant_color")
    @Expose
    private String dominantColor;
    @SerializedName("short_screenshots")
    @Expose
    private List<ShortScreenshot> shortScreenshots = null;
    @SerializedName("parent_platforms")
    @Expose
    private List<ParentPlatform> parentPlatforms = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;

    private String pushId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param esrbRating
     * @param added
     * @param backgroundImage
     * @param rating
     * @param metacritic
     * @param userGame
     * @param playtime
     * @param reviewsCount
     * @param platforms
     * @param score
     * @param dominantColor
     * @param ratings
     * @param genres
     * @param ratingsCount
     * @param saturatedColor
     * @param id
     * @param slug
     * @param released
     * @param stores
     * @param reviewsTextCount
     * @param shortScreenshots
     * @param addedByStatus
     * @param tags
     * @param ratingTop
     * @param tba
     * @param parentPlatforms
     * @param name
     * @param updated
     * @param suggestionsCount
     */
    public Result(String slug, String name, Integer playtime, List<Platform> platforms, List<Store> stores, String released, Boolean tba, String backgroundImage, Double rating, Integer ratingTop, List<Rating> ratings, Integer ratingsCount, Integer reviewsTextCount, Integer added, AddedByStatus addedByStatus, Integer metacritic, Integer suggestionsCount, String updated, Integer id, String score, List<Tag> tags, EsrbRating esrbRating, Integer reviewsCount, String saturatedColor, String dominantColor, List<ShortScreenshot> shortScreenshots, List<ParentPlatform> parentPlatforms, List<Genre> genres, String pushId) {
        super();
        this.slug = slug;
        this.name = name;
        this.playtime = playtime;
        this.platforms = platforms;
        this.stores = stores;
        this.released = released;
        this.tba = tba;
        this.backgroundImage = backgroundImage;
        this.rating = rating;
        this.ratingTop = ratingTop;
        this.ratings = ratings;
        this.ratingsCount = ratingsCount;
        this.reviewsTextCount = reviewsTextCount;
        this.added = added;
        this.addedByStatus = addedByStatus;
        this.metacritic = metacritic;
        this.suggestionsCount = suggestionsCount;
        this.updated = updated;
        this.id = id;
        this.score = score;
        this.tags = tags;
        this.esrbRating = esrbRating;
        this.reviewsCount = reviewsCount;
        this.saturatedColor = saturatedColor;
        this.dominantColor = dominantColor;
        this.shortScreenshots = shortScreenshots;
        this.parentPlatforms = parentPlatforms;
        this.genres = genres;
        this.pushId = pushId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingTop() {
        return ratingTop;
    }

    public void setRatingTop(Integer ratingTop) {
        this.ratingTop = ratingTop;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public Integer getReviewsTextCount() {
        return reviewsTextCount;
    }

    public void setReviewsTextCount(Integer reviewsTextCount) {
        this.reviewsTextCount = reviewsTextCount;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public AddedByStatus getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(AddedByStatus addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public Integer getSuggestionsCount() {
        return suggestionsCount;
    }

    public void setSuggestionsCount(Integer suggestionsCount) {
        this.suggestionsCount = suggestionsCount;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public EsrbRating getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(EsrbRating esrbRating) {
        this.esrbRating = esrbRating;
    }


    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public String getSaturatedColor() {
        return saturatedColor;
    }

    public void setSaturatedColor(String saturatedColor) {
        this.saturatedColor = saturatedColor;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    public List<ShortScreenshot> getShortScreenshots() {
        return shortScreenshots;
    }

    public void setShortScreenshots(List<ShortScreenshot> shortScreenshots) {
        this.shortScreenshots = shortScreenshots;
    }

    public List<ParentPlatform> getParentPlatforms() {
        return parentPlatforms;
    }

    public void setParentPlatforms(List<ParentPlatform> parentPlatforms) {
        this.parentPlatforms = parentPlatforms;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
