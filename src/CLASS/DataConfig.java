/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;


import ENTITY.Member;
import ENTITY.NewSong;
import ENTITY.OldSong;
import ENTITY.Song;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hong
 */


public class DataConfig implements DataConfigInterface{

    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //set the local time
    String dateAndTime = myDateObj.format(myFormatObj);
    
    @Override
    public void addAllMember() {
        MEMBERLIST.add(new Member(1000, "James", "0000", "M", "016-6873901", 10, dateAndTime , ""));
        MEMBERLIST.add(new Member(1001, "Cable", "0000", "M", "016-6873901", 20, dateAndTime , ""));
        MEMBERLIST.add(new Member(1002, "Alvin", "0000", "M", "016-6873901", 50, dateAndTime , ""));
        MEMBERLIST.add(new Member(1003, "Jack", "0000", "M", "016-6873901", 10, dateAndTime , ""));
        
        
    }
     @Override
    public void addSong(){
        SONGLIST.add(new NewSong(1001, "Perfect", "Divide", "Ed Sheeran", 15032022));
        SONGLIST.add(new NewSong(1002, "Let It Go", "Disney", "Idina Menzel", 15032022));
        SONGLIST.add(new NewSong(1003, "Venom", "-", "Eminem", 15032022));
        SONGLIST.add(new NewSong(1004, "Stay", "Kid Laroi", "Justin Bieber", 15032022));
        SONGLIST.add(new NewSong(1005, "Savage Love", "Prod Jawsh", "Jason Derulo", 15032022));
        SONGLIST.add(new NewSong(1006, "Drive you home", "Internet Money", "Jackson Wang", 15032022));
        SONGLIST.add(new NewSong(1007, "100 ways", "-", "Jackson Wang", 15032022));
        SONGLIST.add(new OldSong(1008, "200 ways", "-", "JJ Lee", 20032022, 321));
        SONGLIST.add(new OldSong(1009, "300 ways", "-", "JJ Lee", 20032022, 351));
    }
    
    
}
