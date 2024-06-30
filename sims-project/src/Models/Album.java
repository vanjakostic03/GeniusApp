package Models;

import java.util.ArrayList;

public class Album extends PublishedWork{
    private ArrayList<String> songs;

    public Album() {
        songs = new ArrayList<>();
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public void removeSong(String song) {
        songs.remove(song);
    }
}
