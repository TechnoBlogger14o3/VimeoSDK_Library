package com.techno.vimeosdk.listeners;

import com.techno.vimeosdk.model.TextTrack;

public interface VimeoPlayerReadyListener {
    void onReady(String title, float duration, TextTrack[] textTrackArray);

    void onInitFailed();
}
