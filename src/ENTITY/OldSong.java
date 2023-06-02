/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Lee Jin Jian
 */
public class OldSong extends Song{
    private int dateRemoved;
    private double songLength;

    public OldSong(int songId, String songName, String album, String artist,int dateRemoved, double songLength) {
        super(songId, songName, album, artist);
        this.dateRemoved = dateRemoved;
        this.songLength = songLength;
    }

    public int getYearRemoved() {
        return dateRemoved;
    }

    public void setYearRemoved(int yearRemoved) {
        this.dateRemoved = yearRemoved;
    }

    public double getSongLength() {
        return songLength;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
}
