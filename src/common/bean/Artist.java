package common.bean;

import java.util.ArrayList;

/**
 * Created by Family on 06.09.2016.
 */
public class Artist
{
    private String nickname;
    private ArrayList<Album> albumList;

    //returns album from list if has such
    public Album getAlbum()
    {
        return null;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(ArrayList<Album> albumList) {
        albumList = albumList;
    }

}

