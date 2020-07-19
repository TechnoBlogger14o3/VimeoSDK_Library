package com.techno.vimeosdk.listeners;

public interface VimeoPlayerTextTrackListener {
    void onTextTrackChanged(String kind, String label, String language);
}
