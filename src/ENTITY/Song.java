/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.time.LocalTime;

/**
 *
 * @author Lee Jin Jian
 */
public class Song {
    //var
    private int songId;
    private String songName;
    private String album;
    private String artist;
    private LocalTime dateNow = LocalTime.now();
    private LocalTime dateCreated;
    
    //constructor
    public Song(int songId, String songName, String album, String artist) {
        this.songId = songId;
        this.songName = songName;
        this.album = album;
        this.artist = artist;
        this.dateCreated = dateNow;
    }
    
    //getter
    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getDateCreated() {
        return dateCreated;
    }

    
    //setter
    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    //to String
    @Override
    public String toString(){
       return  String.format("ID: %-10d Name: %-15s Album:"
               + " %-13s Artist: %-13s Date: %-15.8s "
               , songId  ,songName, album, artist, dateCreated );
    }
    
}

