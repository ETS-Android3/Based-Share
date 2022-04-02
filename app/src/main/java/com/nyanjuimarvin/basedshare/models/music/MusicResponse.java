
package com.nyanjuimarvin.basedshare.models.music;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicResponse {

    @SerializedName("albums")
    @Expose
    private Albums albums;
    @SerializedName("artists")
    @Expose
    private Artists artists;
    @SerializedName("tracks")
    @Expose
    private Tracks tracks;
    @SerializedName("playlists")
    @Expose
    private Playlists playlists;
    @SerializedName("shows")
    @Expose
    private Shows shows;
    @SerializedName("episodes")
    @Expose
    private Episodes episodes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusicResponse() {
    }

    /**
     * 
     * @param albums
     * @param shows
     * @param artists
     * @param playlists
     * @param tracks
     * @param episodes
     */
    public MusicResponse(Albums albums, Artists artists, Tracks tracks, Playlists playlists, Shows shows, Episodes episodes) {
        super();
        this.albums = albums;
        this.artists = artists;
        this.tracks = tracks;
        this.playlists = playlists;
        this.shows = shows;
        this.episodes = episodes;
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Playlists getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    public Episodes getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }

}
