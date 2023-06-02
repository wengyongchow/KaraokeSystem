/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Lee Jin Jian
 */
public class NewSong extends Song{
    private int dateUploaded;

    public NewSong( int songId, String songName, String album, String artist,int dateUploaded) {
        super(songId, songName, album, artist);
        this.dateUploaded = dateUploaded;
    }

    public int getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(int dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
}
