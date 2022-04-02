
package com.nyanjuimarvin.basedshare.models.game;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EsrbRating {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_ru")
    @Expose
    private String nameRu;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EsrbRating() {
    }

    /**
     * 
     * @param nameRu
     * @param name
     * @param id
     * @param nameEn
     * @param slug
     */
    public EsrbRating(Integer id, String name, String slug, String nameEn, String nameRu) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.nameEn = nameEn;
        this.nameRu = nameRu;
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

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

}
