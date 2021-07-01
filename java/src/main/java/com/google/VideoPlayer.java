package com.google;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class VideoPlayer {

  private Video currentVideo = null;
  private boolean isPaused = false;

  private final VideoLibrary videoLibrary;
  private final PlaylistLibrary playlistLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.playlistLibrary = new PlaylistLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    var videos = videoLibrary.getVideos();
    videos.sort(Comparator.comparing(Video::getTitle));
    for (var video : videos) {
      System.out.println(video.getTitle() + " (" + video.getVideoId() + ") " + video.getTags().toString().replace(",", ""));
    }
  }

  public void playVideo(String videoId) {
    var newVideo = videoLibrary.getVideo(videoId);

    if ( newVideo == null ) {
      System.out.println("Cannot play video: Video does not exist");
      return;
    }

    if ( currentVideo != null) {
      System.out.println("Stopping video: " + currentVideo.getTitle());
    }

    System.out.println("Playing video: " + newVideo.getTitle());
    currentVideo = newVideo;
    isPaused = false;
  }

  public void stopVideo() {
    if ( currentVideo != null ) {
      System.out.println("Stopping video: " + currentVideo.getTitle());
      currentVideo = null;
    } else {
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    if ( currentVideo != null ) {
      System.out.println("Stopping video: " + currentVideo.getTitle());
    }
    Random rand = new Random();
    Video video = videoLibrary.getVideos().get(rand.nextInt(videoLibrary.getVideos().size()));

    System.out.println("Playing video: " + video.getTitle());
    currentVideo = video;
    isPaused = false;
  }

  public void pauseVideo() {

    if ( isPaused ) {
      System.out.println("Video already paused: " + currentVideo.getTitle());
    } else if ( currentVideo != null) {
      System.out.println("Pausing video: " + currentVideo.getTitle());
      isPaused = true;
    }

    if ( currentVideo == null ) {
      System.out.println("Cannot pause video: No video is currently playing");
    }

  }

  public void continueVideo() {

    if ( currentVideo == null ) {
      System.out.println("Cannot continue video: No video is currently playing");
    } else if (!isPaused) {
      System.out.println("Cannot continue video: Video is not paused");
    } else {
      System.out.println("Continuing video: " + currentVideo.getTitle());
      isPaused = false;
    }

  }

  public void showPlaying() {

    if ( currentVideo == null) {
      System.out.println("No video is currently playing");
    } else if ( isPaused ) {
      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") " + currentVideo.getTags().toString().replace(",", "") + " - PAUSED");
    } else {
      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") " + currentVideo.getTags().toString().replace(",", ""));
    }

  }

  public void createPlaylist(String playlistName) {

    if (playlistLibrary.getPlaylist(playlistName) != null) {
      System.out.println("Cannot create playlist: A playlist with the same name already exists");
    } else {
      System.out.println("Successfully created new playlist: " + playlistName);
      playlistLibrary.addPlaylist(new Playlist(playlistName));
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    if (playlistLibrary.getPlaylist(playlistName) == null) {
      System.out.println("Cannot add video to " + playlistName + ": Playlist does not exist");
    } else if (videoLibrary.getVideo(videoId) == null) {
      System.out.println("Cannot add video to " + playlistName + ": Video does not exist");
    } else {
      playlistLibrary.getPlaylist(playlistName).addVideo(videoLibrary.getVideo(videoId));
    }
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}