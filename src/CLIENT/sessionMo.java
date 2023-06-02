/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLIENT;

import ADT.Queue;
import ADT.QueueInterface;
import CLASS.SessionFunction;
import ENTITY.GuestList;
import ENTITY.Song;
import java.io.IOException;


/**
 *
 * @author Hong
 */
public class sessionMo {

    static void sessionModule() throws IOException {

        //get function form interface page (use = new SessionFunction() to clear data inside)
        SessionFunction session = new SessionFunction();
        QueueInterface<Song> playList = new Queue<>();
        

        


        //declaer a GuestList
        GuestList[] paticipent = session.getPaticipent();
        
        //session method
        playList = session.selectSong();
        
     
        
        session.karaokieStart(paticipent, playList);
        
        
        //end clear queue -- give 10 point to each paticipent
        session.addPoint(paticipent);
        
        
        System.out.println("Thank for Using Session");
        System.out.println("Press Any Key To Exit...");
        System.in.read();
    }

}
