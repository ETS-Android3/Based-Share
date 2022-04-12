package com.nyanjuimarvin.basedshare.models.game;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Game{

    public String name;
    public List<ParentPlatform> platforms;
    public List<Store__1> stores;
    public String imageUrl;
    public List<Genre> genres;
    public String releaseDate;
    public int metacritic;

    public Game(){

    }

    public Game(String name, List<ParentPlatform> platforms, List<Store__1> stores, String imageUrl, List<Genre> genres, String releaseDate, int metacritic) {
        this.name = name;
        this.platforms = platforms;
        this.stores = stores;
        this.imageUrl = imageUrl;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.metacritic = metacritic;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParentPlatform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<ParentPlatform> platforms) {
        this.platforms = platforms;
    }

    public List<Store__1> getStores() {
        return stores;
    }

    public void setStores(List<Store__1> stores) {
        this.stores = stores;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
