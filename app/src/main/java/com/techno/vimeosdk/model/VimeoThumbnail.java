package com.techno.vimeosdk.model;

import com.google.gson.annotations.SerializedName;

public class VimeoThumbnail {

    public @SerializedName("thumbnail_url") String thumbnailUrl;

    public VimeoThumbnail(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
