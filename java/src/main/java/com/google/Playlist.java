package com.google;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Video> videos;

    private String title;
    public Playlist(String title) {
        this.title = title;
        this.videos = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addVideo(Video video) {
        if (videos.contains(video)) {
            System.out.println("Cannot add video to " + this.title + ": Video already added");
            return;
        }
        videos.add(video);
        System.out.println("Added video to " + this.title + ": " + video.getTitle());
    }
}
