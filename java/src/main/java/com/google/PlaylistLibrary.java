package com.google;

import java.util.ArrayList;
import java.util.List;

public class PlaylistLibrary {

    private List<Playlist> playlists;
    public PlaylistLibrary() {
        playlists = new ArrayList<>();
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

   public Playlist getPlaylist(String title) {
       for (Playlist playlist : playlists) {
           if (playlist.getTitle().toLowerCase().equals(title.toLowerCase())) {
               return playlist;
           }
       }
        return null;
   }

   public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
   }

}

