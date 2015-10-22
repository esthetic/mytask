package com.thecabine.sample.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 10/21/15.
 */
public class ItemsResponse {
    @SerializedName("items")
    private List<Item> mItems;

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }
}
