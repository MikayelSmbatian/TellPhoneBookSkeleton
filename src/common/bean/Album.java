package common.bean;

import java.util.ArrayList;

/**
 * Created by Family on 06.09.2016.
 */
public class Album
{
    private String albumName;
    private ArrayList<String> songs;
    private int rating;
    private String artistName;

    public void playSong(String song)
    {
        if(songs.contains(song))
        {
            System.out.println(song);
        }
        else
        {
            System.out.println("Song " + song + " isn't in album " + this.albumName);
        }
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongs() {
        return songs.toString();
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public void incrementRating()
    {
        ++this.rating;
    }

    /**
     * prints album owner, album rating etc
     */
    public void getAlbumInfo()
    {

    }
}
