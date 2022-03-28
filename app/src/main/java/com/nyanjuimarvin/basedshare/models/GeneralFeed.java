package com.nyanjuimarvin.basedshare.models;

public class GeneralFeed {
    private String description;
    private String category;
    private String userName;

    public GeneralFeed(String description, String category, String userName) {
        this.description = description;
        this.category = category;
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
