
package com.nyanjuimarvin.basedshare.models.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Store {

    @SerializedName("store")
    @Expose
    private Store__1 store;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Store() {
    }

    /**
     * 
     * @param store
     */
    public Store(Store__1 store) {
        super();
        this.store = store;
    }

    public Store__1 getStore() {
        return store;
    }

    public void setStore(Store__1 store) {
        this.store = store;
    }

}
